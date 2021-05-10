import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {

	public Examples() {
		LinkedList<String> input = new LinkedList<String>();
		input.add("Gompei");
		input.add("Husky");
		input.add("Bukuria");
		ElectionData ED = new ElectionData(); 
		
		
		ED.printBallot();
		//ED.processData();
		ED.processVote("Bukuria", "Gompei", "Husky");
		ED.processVote("Bukuria", "Husky", "Gompei");
		//System.out.println(ED.countVotes("Gompei"));
		System.out.println(ED.map);
		System.out.println(ED.map.get("Bukuria"));
		System.out.println(ED.map.get("Bukuria").getClass());
		System.out.println(ED.map.containsKey("Bukuria"));
		ED.addCandidate("JositoPocitoSuavcito");
		ED.addCandidate("Meanjew");
		ED.addCandidate("Bukuria");
		System.out.println(ED.map);
		System.out.println(ED.map.get("JositoPocitoSuavcito"));
		ED.processVote("Bukuria", "Bukuria", "Bukuria");
		ED.processVote("Husky", "Bukuria", "Seth");
		ED.processVote("Bukuria", "Gompei", "Husky");
		ED.processVote("JositoPocitoSuavcito", "Gompei", "Husky");
		ED.processVote("Bukuria" , "JositoPocitoSuavcito", "Meanjew");
		System.out.println(ED.map);
		VotingMachine VM = new VotingMachine(ED);
		System.out.println(VM);
		//System.out.println(VM.map.map);
		//System.out.println(VM.map.votes);
		System.out.println(VM.findWinnerFirstMostVoters());
		//System.out.println(ED.findFirstTier());
		//System.out.println(ED.findSecondTier());
		//System.out.println(ED.findThirdTier());
		System.out.println(VM.findWinnerMostPoints());
		
		
	}
	
	@Test
	public void testWinnerByPoints() {
		
		ElectionData ED = new ElectionData();
		ED.addCandidate("JositoPocitoSuavcito");
		ED.addCandidate("Meanjew");
		ED.addCandidate("Bukuria");
		ED.processVote("Bukuria", "Gompei", "Husky");
		ED.processVote("Bukuria", "Husky", "Gompei");
		ED.processVote("Bukuria", "Bukuria", "Bukuria");
		ED.processVote("Husky", "Bukuria", "Seth");
		ED.processVote("Bukuria", "Gompei", "Husky");
		ED.processVote("JositoPocitoSuavcito", "Gompei", "Husky");
		ED.processVote("Bukuria" , "JositoPocitoSuavcito", "Meanjew");
		VotingMachine VM = new VotingMachine(ED); 

		
		assertEquals(VM.findWinnerMostPoints(), "The winner is: Bukuria");
	}
	
	@Test
	public void testWinnerByTier1() {

		ElectionData ED = new ElectionData();
		ED.addCandidate("JositoPocitoSuavcito");
		ED.addCandidate("Meanjew");
		ED.addCandidate("Bukuria");
		ED.processVote("Bukuria", "Gompei", "Husky");
		ED.processVote("Bukuria", "Husky", "Gompei");
		ED.processVote("Bukuria", "Bukuria", "Bukuria");
		ED.processVote("Husky", "Bukuria", "Seth");
		ED.processVote("Bukuria", "Gompei", "Husky");
		ED.processVote("JositoPocitoSuavcito", "Gompei", "Husky");
		ED.processVote("Bukuria" , "JositoPocitoSuavcito", "Meanjew");
		VotingMachine VM = new VotingMachine(ED); 

		assertEquals(VM.findWinnerFirstMostVoters(), "Bukuria");
	}
	
	@Test
	public void testWinnerByTier1RunoffRequired() {
		
		ElectionData ED = new ElectionData();
		ED.processVote("Bukuria", "Gompei", "Husky");
		ED.processVote("Gompei", "Bukuria", "Husky");
		ED.processVote("Husky", "Bukuria", "Gompei");
		VotingMachine VM = new VotingMachine(ED); 

		
		assertEquals(VM.findWinnerFirstMostVoters(), " Runoffs required ");
	}

	@Test
	public void testWinnerByTier1RunoffRequiredv2() {
		VotingMachine VM= new VotingMachine(new ElectionData());
		
		
		assertEquals(VM.findWinnerFirstMostVoters(), " Runoffs required ");
	}
	
	
	
}
