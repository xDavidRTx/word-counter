import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DomainSpec extends AnyFlatSpec with Matchers {
  val event1: Event = Event("foo", "hello", 0L)
  val event2: Event = Event("bar", "bye", 4L)
  val events: List[Event] = event1 :: event2 :: Nil

  "Given a current Window it" must "be updated for a new event" in {
    Window(0L, event1 :: Nil).update(event2) should be(Window(0L, event2 :: event1 :: Nil))
  }

  "Given a current Window it" must "reset with a new epoch" in {
    Window(1L, event1 :: Nil).resetWindow(3L, event2) should be(Window(3L, event2 :: Nil))
  }
}
