import java.util.LinkedList;
import java.util.HashMap;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	

}
