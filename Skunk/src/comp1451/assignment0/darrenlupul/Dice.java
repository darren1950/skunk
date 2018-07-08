package comp1451.assignment0.darrenlupul;

import java.util.Random;

public class Dice {
	
	public static int getDieRoll() {
		
		//roll for random number between 1 and 6
		
		Random r = new Random();
		int die = r.nextInt(6)+1;
		return die;
		
	}

}
