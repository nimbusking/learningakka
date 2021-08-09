package cc.nimbusk.akka.learningakka.chapter2;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;

/**
 * TODO
 *
 * @author nimbus.k 2021-08-09 22:22
 * @version 1.0
 */
public class JavaPongActor extends AbstractActor {
    public PartialFunction receive() {
        return ReceiveBuilder
                .matchEquals("Ping", s -> sender().tell("Pong", ActorRef.noSender()))
                .matchAny(x -> sender().tell(new Status.Failure(new Exception("unknown message")), self()))
                .build();
    }
}
