import com.typesafe.scalalogging.LazyLogging
import org.json4s.jackson.JsonMethods.parse
import org.json4s.{DefaultFormats, Formats}

import scala.util.{Failure, Success, Try}

object Utils extends LazyLogging {
  implicit val formats: Formats = DefaultFormats

  def getEvent(input: String): Option[Event] = Try {
    parse(input).extract[Event]
  } match {
    case Failure(exception) =>
      logger.warn(s"Unable to parse event for the input $input due to ${exception.getMessage}")
      None
    case Success(value) => Some(value)
  }
}
