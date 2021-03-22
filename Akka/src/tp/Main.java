package tp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		ActorSystem system = ActorSystem.create("MySystem");
		ActorRef greeter1, greeter2, greeter3 ,greeter4,
		greeter5,greeter6,greeter7,greeter8;
		
		HashMap<String, Integer> listWord =new HashMap<String, Integer>();
				
		greeter5=system.actorOf(Props.create(ReducerActor.class,"reducer1",listWord), "greeter5");
		greeter6=system.actorOf(Props.create(ReducerActor.class,"reducer2",listWord), "greeter6");
		greeter7=system.actorOf(Props.create(ReducerActor.class,"reducer3",listWord), "greeter7");
		greeter8=system.actorOf(Props.create(ReducerActor.class,"reducer4",listWord), "greeter8");

		
		HashMap<String, ActorRef> list=new HashMap<String, ActorRef>(); 
		list.put("a", greeter5);
		list.put("h", greeter6);
		list.put("n", greeter7);
		list.put("o", greeter8);

		greeter1=system.actorOf(Props.create(GreetingActor.class,"master",list), "greeter1");
		greeter2=system.actorOf(Props.create(GreetingActor.class,"mapper1",list), "greeter2");
		greeter3=system.actorOf(Props.create(GreetingActor.class,"mapper2",list), "greeter3");
		greeter4=system.actorOf(Props.create(GreetingActor.class,"mapper3",list), "greeter4");
		
		
		// Partie Fichier
		
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\lardjani\\Desktop\\M1S2\\CAR\\TP\\Akka\\lib\\test.txt"));
		String line;
		int i=0;
		while ((line = in.readLine()) != null)
		{
			if(i%3==0) 
			{		
				greeter2.tell(line, ActorRef.noSender());
				i++;				
			}
			else if(i%3==1) 
			{
				greeter3.tell(line, ActorRef.noSender());
				i++;
				
			}
			else if(i%3==2) 
			{
				greeter4.tell(line, ActorRef.noSender());
				i++;
			
			}
			
			
			


		}
		in.close();
        TimeUnit time = TimeUnit.SECONDS; 
        time.sleep(1); 

		System.out.println(listWord.size());
		
		for (String i1 : listWord.keySet()) {
		      System.out.println("Le mot : " + i1 + "   est r�p�ter : " + listWord.get(i1) +" fois");
		    }
		
		system.shutdown();

	

		

		
	}

}
