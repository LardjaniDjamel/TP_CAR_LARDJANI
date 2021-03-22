package tp;

import java.util.HashMap;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class ReducerActor extends UntypedActor{
	protected String name;
	//public HashMap<String, Integer> listWord =new HashMap<String, Integer>();  
	public HashMap<String, Integer> listWord;  

	public ReducerActor(String name,HashMap<String, Integer> l) {	
		this.name=name;
		this.listWord=l;
	}
	
	
	public void onReceive(Object message) {
		if(this.listWord.containsKey(message)) {
			this.listWord.put( message.toString(),this.listWord.get(message)+1);
		}
		else {
			this.listWord.put( message.toString(),1);

		}
		
		
	    //  System.out.println("key: " + "a" + " value: " + listWord.get("a"));
		/*
		for (String i : this.listWord.keySet()) {
		      System.out.println(this.name+" "+"key: " + i + " value: " + listWord.get(i));
		    }
	*/
	}


	public HashMap<String, Integer> getListWord() {
		return listWord;
	}


	public void setListWord(HashMap<String, Integer> listWord) {
		this.listWord = listWord;
	}
	
	
	
	
	
	
	


}
