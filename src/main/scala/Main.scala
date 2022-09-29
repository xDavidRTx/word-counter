import Domain.windowSize
import cats.effect.IO
import com.twitter.finagle.Http
import com.typesafe.scalalogging.LazyLogging
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps
import io.finch.circe._
import io.finch.{Application, Endpoint, Ok}

import java.io.{BufferedReader, InputStreamReader}

private object Main extends App with Endpoint.Module[IO] with LazyLogging {

  val proc = Runtime.getRuntime.exec({
    "java -jar blackbox.jar -get t"
  })
  val stdInput     = new BufferedReader(new InputStreamReader(proc.getInputStream))
  val currentState = CurrentWordCount()

  val currentWordCount = get("current") { () =>
    Ok(Map("event_types" -> currentState.data).asJson)
  }

  Http.server.serve(":8000", currentWordCount.toServiceAs[Application.Json])

  Iterator
    .continually(stdInput)
    .takeWhile(_ != null)
    .flatMap(line => Utils.getEvent(line.readLine))
    .foldLeft(Window()) {
      //Add do current window
      case (currentWindow, event)
          if currentWindow.startTime to currentWindow.startTime + windowSize contains event.timestamp =>
        currentWindow.update(event)
      //Move Window forward and recompute the current data
      case (currentWindow, event) if currentWindow.startTime + windowSize < event.timestamp =>
        currentState.update(currentWindow)
        logger.debug("Moving to a new window")
        currentWindow.resetWindow(currentWindow.startTime + windowSize, event).update(event)
      //Unexpected event ignoring
      case (currentWindow, _) =>
        logger.warn("Unexpected event ignoring")
        currentWindow
    }
}
