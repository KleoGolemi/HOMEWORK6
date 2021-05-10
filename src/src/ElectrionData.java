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
  
  public void processVote(String vote, String vote2, String vote3) {
	 
	  if( ((vote != vote2) && (vote != vote2) && (vote2  != vote3))
			  &&
			  (map.containsKey(vote) && map.containsKey(vote2) && map.containsKey(vote3))){
	  this.printBallot();
	   votes.add(vote);
	   votes.add(vote2);
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
  
  
  
  }
