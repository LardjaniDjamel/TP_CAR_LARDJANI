package tp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main2System {
	
	
	
public static void main(String[] args) throws IOException, InterruptedException {
	
		com.typesafe.config.Config configurtion1 =ConfigFactory.parseString(
				("akka { \n"
				+ "		remote {\n"
				+ " 		enabled-transports = [\"akka.remote.netty.tcp\"]\n"
				+ "			netty.tcp {\n"
				+ "				hostname = \"localhost\"\n"
				+ "				port = 2552\n"
				+ "			}\n"
				+ "		}}"));
		
		com.typesafe.config.Config configurtion2 =ConfigFactory.parseString(
				("akka { \n"
				+ "		remote {\n"
				+ " 		enabled-transports = [\"akka.remote.netty.tcp\"]\n"
				+ "			netty.tcp {\n"
				+ "				hostname = \"localhost\"\n"
				+ "				port = 2553\n"
				+ "			}\n"
				+ "		}}"));
		
		ArrayList<ActorRef> ListMapper= new ArrayList<ActorRef>();

		ActorSystem system = ActorSystem.create("MySystem",configurtion1);
		ActorSystem system1 = ActorSystem.create("MySystem1",configurtion2);
		

		
		ActorRef greeter1, greeter2, greeter3 ,greeter4,
		greeter5,greeter6,greeter7,greeter8;
		
		HashMap<String, Integer> listWord =new HashMap<String, Integer>();
				
		greeter5=system.actorOf(Props.create(ReducerActor.class,"reducer1",listWord), "greeter5");
		greeter6=system.actorOf(Props.create(ReducerActor.class,"reducer2",listWord), "greeter6");
		greeter7=system1.actorOf(Props.create(ReducerActor.class,"reducer3",listWord), "greeter7");
		greeter8=system1.actorOf(Props.create(ReducerActor.class,"reducer4",listWord), "greeter8");

		
		HashMap<String, ActorRef> list=new HashMap<String, ActorRef>(); 
		list.put("a", greeter5);
		list.put("h", greeter6);
		list.put("n", greeter7);
		list.put("o", greeter8);

		greeter1=system.actorOf(Props.create(GreetingActor.class,"master",list), "greeter1");
		greeter2=system.actorOf(Props.create(GreetingActor.class,"mapper1",list), "greeter2");
		greeter3=system1.actorOf(Props.create(GreetingActor.class,"mapper2",list), "greeter3");
		greeter4=system.actorOf(Props.create(GreetingActor.class,"mapper3",list), "greeter4");
		
		ListMapper.add(greeter2);
		ListMapper.add(greeter3);
		ListMapper.add(greeter4);
		// Partie Fichier
		
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\lardjani\\Desktop\\M1S2\\CAR\\TP\\Akka\\lib\\test.txt"));
		String line;
		int i=0;
		while ((line = in.readLine()) != null)
		{
			
			ListMapper.get(i%(ListMapper.size())).tell(line, ActorRef.noSender());
			i++;

		}
		in.close();
        TimeUnit time = TimeUnit.SECONDS; 
        time.sleep(1); 

		System.out.println(listWord.size());
		
		for (String i1 : listWord.keySet()) {
		      System.out.println("Le mot : " + i1 + "   est répéter : " + listWord.get(i1) +" fois");
		    }
		
		system.shutdown();

	

		

		
	}
	
	

}
