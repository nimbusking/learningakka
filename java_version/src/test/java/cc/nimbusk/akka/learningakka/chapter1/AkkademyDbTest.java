package cc.nimbusk.akka.learningakka.chapter1;

import static org.junit.Assert.assertEquals;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import cc.nimbusk.akka.learningakka.chapter1.messages.SetRequest;
import org.junit.Test;

public class AkkademyDbTest {

    // 一个包含所有Actor信息的ActorSystem
    ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
        // 通过TestActorRef来获取一个AkkademyDb对应的Actor引用
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        // 使用“tell”或是Scala 中的“！”（仍然读作“tell”）将消息放入Actor 的邮箱中。
        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());

        AkkademyDb akkademyDb = actorRef.underlyingActor();
        assertEquals(akkademyDb.map.get("key"), "value");
    }

}
