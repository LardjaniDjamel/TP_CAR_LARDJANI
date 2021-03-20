package tp;

import akka.actor.UntypedActor;

public class GreetingActor extends UntypedActor{

	@Override
	public void onReceive(Object message) throws Exception {
		
		if( message instanceof Greeting ) 
		{ 
			System.out.println(message +"instance");
			
		}
		else if( message instanceof String ) 
		{ 
			System.out.println(message +"string");

		}
		else 
		{ 
			unhandled(message); 
		}

		
	}

}
