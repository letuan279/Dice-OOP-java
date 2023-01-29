package dice;

import java.util.*;

public class Dice {
	private int dotNumber;
	private int specialPercent;
	private int value;
	private int specialValue;
	
	public Dice(int specialValue) {
		this.dotNumber = 6;
		this.specialPercent = 20;
		this.specialValue = specialValue;
		this.value = 0;
	}
	
	public int getDotNumber() {
		return dotNumber;
	}

	public void setDotNumber(int dotNumber) {
		this.dotNumber = dotNumber;
	}

	public int getSpecialPercent() {
		return specialPercent;
	}

	public void setSpecialPercent(int specialPercent) {
		this.specialPercent = specialPercent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getSpecialValue() {
		return specialValue;
	}

	public void setSpecialValue(int specialValue) {
		this.specialValue = specialValue;
	}
	
	public void roll() {		
		Random r = new Random();
	    int percent = r.nextInt(100);
	    
	    if (percent < 20){ // 20%
	    	setValue(getSpecialValue());
	    }
	    else { // 16%
	    	List<Integer> dots = new ArrayList<Integer>(getDotNumber());
	    	for(int i = 1; i <= getDotNumber(); ++i) {
	    		dots.add(i);
	    	}
	    	dots.remove(getSpecialValue());
	    	r = new Random();
		    int randomIndex = r.nextInt(4);
		    setValue(dots.get(randomIndex));
	    }
	}
}
