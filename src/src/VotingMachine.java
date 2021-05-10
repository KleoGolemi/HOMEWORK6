import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

public class VotingMachine {
	//LinkedList<String> votes;
	ElectionData ED;
	
	VotingMachine(ElectionData ED){
		this.ED = ED;
		
	}
	

	  //works perfectly
	  public String findWinnerFirstMostVoters() {
		  LinkedList<String> FirstPlaceList= new LinkedList<String>();
		  HashMap<String, Integer> tracking = new HashMap<String, Integer>();
		  int count = 0; 
		  String WinnerWinnerChickenDinner = " " ;
		  
		  if( ED.votes.size() != 0) {
		  for ( int i = 0; i< ED.votes.size(); i = i + 3) {
			  FirstPlaceList.add(ED.votes.get(i));
		  }
		  for (int i = 0; i < FirstPlaceList.size(); i++) {
			  count = count + 1;
			  if( !tracking.containsKey(FirstPlaceList.get(i))) {
				  tracking.put(FirstPlaceList.get(i), 1);
			  }
			  else												//edit duplicates
				  tracking.put(FirstPlaceList.get(i), tracking.get(FirstPlaceList.get(i)) + 1);
		  }
		  for (int i = 0; i < tracking.size(); i++) {
			  if ( tracking.get(FirstPlaceList.get(i)) > count/2 ) {
				 // System.out.println( FirstPlaceList.get(i) + " has more than 50% of the votes");
				  WinnerWinnerChickenDinner = FirstPlaceList.get(i); 
			  }
			  else 
				  WinnerWinnerChickenDinner =  " Runoffs required ";
			  }
		  }
		  else
			  WinnerWinnerChickenDinner =  " Runoffs required ";
		  return WinnerWinnerChickenDinner;
		 
		 //System.out.println(tracking + " " + count + " " + tracking.size());
		  //System.out.println(tracking.size());
	  }
	  
	  
	  public HashMap findFirstTier() {
		  LinkedList<String> FirstPlaceList= new LinkedList<String>();
		  HashMap<String, Integer> tracking = new HashMap<String, Integer>();
		  int count = 0; 
		  String result = " " ;
		  for ( int i = 0; i< ED.votes.size(); i = i + 3) {
			  FirstPlaceList.add(ED.votes.get(i));
		  }
		  for (int i = 0; i < FirstPlaceList.size(); i++) {
			  count = count + 1;
			  if( !tracking.containsKey(FirstPlaceList.get(i))) {
				  tracking.put(FirstPlaceList.get(i), 3);
			  }
			  else												//edit duplicates
				  tracking.put(FirstPlaceList.get(i), tracking.get(FirstPlaceList.get(i)) + 3);
		  }
		  //System.out.println(tracking);
		  return tracking;
	  }
	  
	  public HashMap findSecondTier() {
		  LinkedList<String> FirstPlaceList= new LinkedList<String>();
		  HashMap<String, Integer> tracking = new HashMap<String, Integer>();
		  int count = 0; 
		  String result = " " ;
		  for ( int i = 1; i< ED.votes.size(); i = i + 3) {
			  FirstPlaceList.add(ED.votes.get(i));
		  }
		  for (int i = 0; i < FirstPlaceList.size(); i++) {
			  count = count + 1;
			  if( !tracking.containsKey(FirstPlaceList.get(i))) {
				  tracking.put(FirstPlaceList.get(i), 2);
			  }
			  else												//edit duplicates
				  tracking.put(FirstPlaceList.get(i), tracking.get(FirstPlaceList.get(i)) + 2);
		  }
		 // System.out.println(tracking);
		  return tracking;
	  }
	  
	  private HashMap findThirdTier() {
		  LinkedList<String> FirstPlaceList= new LinkedList<String>();
		  HashMap<String, Integer> tracking = new HashMap<String, Integer>();
		  int count = 0; 
		  String result = " " ;
		  for ( int i = 2; i< ED.votes.size(); i = i + 3) {
			  FirstPlaceList.add(ED.votes.get(i));
		  }
		  for (int i = 0; i < FirstPlaceList.size(); i++) {
			  count = count + 1;
			  if( !tracking.containsKey(FirstPlaceList.get(i))) {
				  tracking.put(FirstPlaceList.get(i), 1);
			  }
			  else												//edit duplicates
				  tracking.put(FirstPlaceList.get(i), tracking.get(FirstPlaceList.get(i)) + 1);
		  }
		//  System.out.println(tracking);
		  return tracking;
	  }
	  
	  
	  
	  public String findWinnerMostPoints() { 
		  HashMap<Object, Object> Points = new HashMap<Object, Object>();
		  int maxValue = 0;
		  String WinnerWinnerChickenDinner = " " ; 
		  
		 for(Object key : this.findThirdTier().keySet()) {
			if ( !Points.containsKey(key)) {
				Points.put(key, this.findThirdTier().get(key));
			}
			else
				Points.put(key, (Integer) Points.get(key) + 1);
		 }
		 

		 for(Object key : this.findSecondTier().keySet()) {
			if ( !Points.containsKey(key)) {
				Points.put(key, this.findSecondTier().get(key));
			}
			else
				Points.put(key, (Integer) Points.get(key) + (Integer) findSecondTier().get(key));
		 }
		 

		 for(Object key : this.findFirstTier().keySet()) {
			if ( !Points.containsKey(key)) {
				Points.put(key, this.findFirstTier().get(key));
			}
			else
				Points.put(key, (Integer) Points.get(key) + (Integer) findFirstTier().get(key));
		 }
		 
		 for(Object key : Points.keySet()) {
			 if ((Integer) Points.get(key) > maxValue) {
				 WinnerWinnerChickenDinner = (String) key;
				 maxValue = (Integer) Points.get(key);
			 }
						 
		 }
		  return "The winner is: " + WinnerWinnerChickenDinner;
	  }
}
