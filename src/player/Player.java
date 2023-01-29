package player;

import dice.Dice;

public class Player {
	private String name;
	private int currPoint;
	
	public Player(String name) {
		this.name = name;
		this.currPoint = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrPoint() {
		return currPoint;
	}
	public void setCurrPoint(int currPoint) {
		this.currPoint = currPoint;
	}
	
	public void roll(Dice dice) {
		System.out.println(name + " is rolling...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dice.roll();
		setCurrPoint(currPoint + dice.getValue());
		System.out.println(name + " got " + dice.getValue() + " point!");
	}
}
