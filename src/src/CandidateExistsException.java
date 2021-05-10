
public class CandidateExistsException extends Exception{
	String candidate;
	
	CandidateExistsException(String candidate){
		this.candidate = candidate;
	}
	
	public String getName() {
		return this.candidate;
	}
	
	
}
