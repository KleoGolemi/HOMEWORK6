import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

class ElectionData {
	public HashMap<String, LinkedList<String>> map = 
			new HashMap< String, LinkedList<String>>();
  LinkedList<String> ballot = new LinkedList<String>();
  LinkedList<String> votes = new LinkedList<String>();
  Scanner keyboard = new Scanner(System.in);
  
  ElectionData() {
	  
	  this.ballot.add("Gompei");
	  this.ballot.add("Husky");
	  this.ballot.add("Bukuria");
	    
	    
	    //canditate , List of Votes
	map.put("Gompei", votes);
	map.put("Husky", votes);
	map.put("Bukuria", votes);
	
  }
  
  public void printBallot() {
    System.out.println("The candidates are ");
    for (String s : ballot) {
      System.out.println(s);
    }
  }
  
  /*
   *  public LinkedList<String> printBallot() {
	  LinkedList<String> rsf = new LinkedList<String>();
    System.out.println("The candidates are ");
    for (String s : ballot) {
     //System.out.println(s);
    	rsf.add(s);
    }
    return rsf;
  }
   */
  /*
  public void screen() {
    this.printBallot();
    System.out.println("Who is your first vote?");
    String candidate = keyboard.next();
    votes.add(candidate);
    System.out.println("Who is your second vote?");
    String candidate2 = keyboard.next();
    votes.add(candidate2);
    System.out.println("Who is your third vote??");
    String candidate3 = keyboard.next();
    votes.add(candidate3);
    System.out.println("You voted for "  + candidate + ", " +  candidate2 + ", " + candidate3);
  }
  */
  
  public void processVote(String vote, String vote2, String vote3) {
	 
	  if( ((vote != vote2) && (vote != vote2) && (vote2  != vote3))
			  &&
			  (map.containsKey(vote) && map.containsKey(vote2) && map.containsKey(vote3))){
	  this.printBallot();
	  System.out.println("Who is your first vote?");
	   votes.add(vote);
	   System.out.println("Who is your seconds vote?");
	   votes.add(vote2);
	   System.out.println("Who is your third vote?");
	   votes.add(vote3);
	    System.out.println("You voted for "  + vote + ", " +  vote2 + ", " + vote3);
	    }
	  else 
		  System.out.println("Invalid Vote");
	  
  }
  
  public void addCandidate(String Candidate){ 
	   if(!map.containsKey(Candidate)) {
		   map.put(Candidate, votes);
	   }
	   else 
		   System.out.println("Screw off");
  }
  
  public int countVotes(String forcand) {
    int numvotes = 0;
  for(String aCand : this.map.get(forcand))  {
	  if(aCand.equals(forcand)) {                     // for some reason aCand == forcand doesnt work
	  numvotes = numvotes + 1;
   }
  }
    return numvotes;
    }
  
  
  //works perfectly
  public void findWinnerFirstMostVoters() {
	  LinkedList<String> FirstPlaceList= new LinkedList<String>();
	  HashMap<String, Integer> tracking = new HashMap<String, Integer>();
	  int count = 0; 
	  String result = " " ;
	  for ( int i = 0; i< votes.size(); i = i + 3) {
		  FirstPlaceList.add(votes.get(i));
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
			  result = FirstPlaceList.get(i); 
		  }
		  else 
			  result =  " Runoffs required ";
	  }
	  System.out.println(result);
	 
	 //System.out.println(tracking + " " + count + " " + tracking.size());
	  //System.out.println(tracking.size());
  }
  
  
  public HashMap findFirstTier() {
	  LinkedList<String> FirstPlaceList= new LinkedList<String>();
	  HashMap<String, Integer> tracking = new HashMap<String, Integer>();
	  int count = 0; 
	  String result = " " ;
	  for ( int i = 0; i< votes.size(); i = i + 3) {
		  FirstPlaceList.add(votes.get(i));
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
	  for ( int i = 1; i< votes.size(); i = i + 3) {
		  FirstPlaceList.add(votes.get(i));
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
  
  public HashMap findThirdTier() {
	  LinkedList<String> FirstPlaceList= new LinkedList<String>();
	  HashMap<String, Integer> tracking = new HashMap<String, Integer>();
	  int count = 0; 
	  String result = " " ;
	  for ( int i = 2; i< votes.size(); i = i + 3) {
		  FirstPlaceList.add(votes.get(i));
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
  
  
  
  public void findWinnerMostPoints() { 
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
	  System.out.println("Results are: " + Points + " and the winner is: " + WinnerWinnerChickenDinner);
  }
  
  }
