package tp;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


public class Main {

	public static void main(String[] args) {
		
		ActorSystem system = ActorSystem.create("MySystem");
		ActorRef greeter1, greeter2;
		
		greeter1=system.actorOf(Props.create(GreetingActor.class), "greeter1");
		greeter2=system.actorOf(Props.create(GreetingActor.class), "greeter2");
		
		greeter1.tell( new Greeting("Bob"), ActorRef.noSender() );
		greeter2.tell("salut", ActorRef.noSender());
		
		system.shutdown();


	}

}
