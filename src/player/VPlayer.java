package player;

import java.util.*;

public class VPlayer extends Player{
	private String loseSentence;
	
	public VPlayer(String name) {
		super(name);
		List<String> sentences = new ArrayList<String>();
		sentences.add("Cay chua");
		sentences.add("Ty thi win");
		sentences.add("Hen that day");
		sentences.add("Lam van nua phat");
		Random r = new Random();
		this.loseSentence = sentences.get(r.nextInt(4));
	}
	
	public String getLoseSentence() {
		return loseSentence;
	}

	public void setLoseSentence(String loseSentence) {
		this.loseSentence = loseSentence;
	}

	public void loseBehavior() {
		System.out.println(this.getName() + " : " + loseSentence);
	}
}
