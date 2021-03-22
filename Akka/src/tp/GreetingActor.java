package tp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class GreetingActor extends UntypedActor{
	
	protected String name;
	public Map<String, ActorRef> listReducer=new HashMap<String, ActorRef>();  
	public HashMap<String, Integer> listWord ;

	
	public GreetingActor (String name,HashMap<String, ActorRef> l) {
		this.name=name;
		this.listReducer=l; 
		//this.listWord=new HashMap<String, Integer>(); 
	}

	@Override
	public void onReceive(Object message) {
		
	
			String[] arrOfStr = message.toString().split(" "); 		
			for (String a : arrOfStr) {
				if (a.length()>0) {
					//System.out.println(this.name + " has received  a greeting message :" +a );
					ActorRef actor=this.partition(a);
					//System.out.println(actor.toString());

					actor.tell(a, ActorRef.noSender());
					
				}
				
				
				
			}        						
	
	}
	
	public ActorRef partition(String a) {
		//System.out.println(a);

		int  c=(int)a.charAt(0);
		
		//System.out.println(c);

		if (c >=97 && c < 104) {
			//System.out.println("truc");
    		return this.listReducer.get("a");
    	}
    	else if (c>=104 && c<110) {
			//System.out.println("truc");
    		return this.listReducer.get("h");
    	}
    	else if (c>=110 && c<116) {
			//System.out.println("truc");

    		return this.listReducer.get("n");
    	}
    	else  {//System.out.println("truc");

    		return this.listReducer.get("o");
    	}
        		
	}

	public Map<String, ActorRef> getListReducer() {
		return listReducer;
	}

	public void setListReducer(HashMap<String, ActorRef> listReducer) {
		this.listReducer = listReducer;
	}


	

}
