package co.adhoclabs.task.producer

import akka.actor.ActorSystem
import akka.testkit.{ ImplicitSender, TestActorRef, TestKit }
import co.adhoclabs.task._
import org.scalatest.{ BeforeAndAfterAll, Matchers, WordSpecLike }

/**
 * Created by yeghishe on 5/11/15.
 */
class CommonProducerActorTest extends TestKit(ActorSystem("test-system"))
    with Config
    with ImplicitSender
    with WordSpecLike
    with Matchers
    with BeforeAndAfterAll {

  private val taskType = TaskType.demo

  "CommonProducerActor" should {
    "have endpointUri set correct" in {
      val actorRef = TestActorRef.create[CommonProducerActor](system, CommonProducerActor.props(taskType))
      actorRef.underlyingActor.endpointUri should be(getCommonEndpointUrlFromTaskType(taskType))
      system.stop(actorRef)
    }
  }
}
