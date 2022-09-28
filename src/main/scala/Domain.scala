import Domain.{EventType, Word}

import scala.collection.mutable

case class Event(event_type: EventType, data: Word, timestamp: Long)

case class WordCount(word: String, count: Int)

case class Window(startTime: Long = 0, events: List[Event] = Nil) {
  def update(event: Event): Window = this.copy(events = event :: events)

  def resetWindow(startTime: Long, firstEvent: Event): Window = if (this.startTime == 0) Window(firstEvent.timestamp, firstEvent :: Nil)
  else this.copy(startTime, firstEvent :: Nil)
}


case class CurrentWordCount(data: mutable.Map[(EventType, Word), Int] = mutable.Map.empty) extends AnyVal {
  def update(window: Window): Unit = {
    window.events.foreach { event =>
      data.updateWith((event.event_type, event.data)) {
        case None => Some(1)
        case Some(n) => Some(n + 1)
      }
    }
  }
}

object Domain {
  type EventType = String
  type Word = String
  //5 Seconds
  lazy val windowSize: Long = 5 * 1000L
}