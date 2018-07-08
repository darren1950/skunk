package comp1451.assignment0.darrenlupul;

import java.util.Scanner;



public class Skunk {
	
	private int playerTotalScore;
	private int computerTotalScore;
	private int playerRoundScore;
	private int computerRoundScore;
	private int gameRound;
	private boolean playerPlaying;
	private boolean computerPlaying;
	
	
	
	public Skunk() {
		
		this.playerTotalScore = 0;
		this.computerTotalScore = 0;
		this.playerRoundScore = 0;
		this.computerRoundScore = 0;
		this.gameRound = 1;
		this.playerPlaying = true;
		this.computerPlaying = true;
				
	}	
	
	public void GameSetup() {
		
		System.out.println("\t\tSKUNK game");
		System.out.println("\t\t==========");
		System.out.println(" ");
		
		System.out.println("Enter S to stay, R to continue");
		System.out.println(" ");
		

		GamePlay();


		
		
	}
	
	

	public void GamePlay() {
		

		
		//we will do 5 rounds for each of S-K-U-N-K
		for (int round = 1; round < 6; round++) {
			this.gameRound = round;

			//initial beginning of round
			this.playerRoundScore = 0;
			this.computerRoundScore = 0;
			this.playerPlaying = true;
			this.computerPlaying = true;

			displayScores();
			
			
			//while either player is still playing the round
			while ((playerPlaying == true) || (computerPlaying == true)) {
			playerInput();
			FigureOutRoll();
			displayScores();
			}

			
		}
		
	}
	
	
	public void displayScores() {
		

		System.out.println();
		System.out.println("This is round "+gameRound+" of 5 rounds");
		System.out.println("You have " + playerRoundScore + " round score for a total score of " + playerTotalScore);
		System.out.println("Computer has " + computerRoundScore + " round score for a total score of " + computerTotalScore);
		System.out.println();
		
	}
	
	public void playerInput() {
		
		Scanner s = new Scanner(System.in);
		char input = 0;
		
		System.out.println(playerPlaying);
		
		//player hasn't stayed yet, get inputs and change status
		while (playerPlaying == true) {
			System.out.println(playerPlaying+"first");
			while ((input != 's') && (input != 'r')) {
				System.out.println("Enter lower case s to stay, r to continue rolling, then press Enter");
				input = s.next().trim().charAt(0);
			
				if (input == 's') {
					playerPlaying = false;
					break;
				}
				System.out.println(playerPlaying+"second");
				input = 0;
				System.out.println(input);
			}
		}
		
		while (computerPlaying == true) {
			//randomly decide whether computer will continue or will stay
			int randomRoll = Dice.getDieRoll();
			//1 in 6 chance computer will decide to stay
			if (randomRoll == 1) {
				computerPlaying = false;
			}
			
			
			
		}
	
	
	System.out.println(input);
		
		
	}
	

	
	public void FigureOutRoll() {
		
		int die1=Dice.getDieRoll();
		int die2=Dice.getDieRoll();
		int die3=Dice.getDieRoll();
		
		System.out.println(die1+" "+die2+" "+die3+" "+gameRound);
		
	
			if (die1 + die2 + die3 == 3) {
				if (playerPlaying) {
					playerRoundScore = playerRoundScore + 100;
				}
				if (computerPlaying) {
					computerRoundScore = computerRoundScore + 100;
				}
			return;
			}
			
			if ((die1 == 1) || ((die2 == 1)&&(die3 == 1))) {
				if ((die2 == 1)||(die3 == 1)) {
					if (playerPlaying) {
						playerRoundScore = 0;
						playerTotalScore = 0;
						playerPlaying = false;
					}
					if (computerPlaying) {
						computerRoundScore = 0;
						computerTotalScore = 0;
						computerPlaying = false;
					}
				return;
				}

			}
			
			
			if ((die1 == 1) || (die2 == 1) || (die3 == 1)) {
				if (playerPlaying) {
					playerRoundScore = 0;
					playerPlaying = false;
				}
				if (computerPlaying) {
					computerRoundScore = 0;
					computerPlaying = false;
				}
				return;
			}
			
			if (playerPlaying) {
				playerRoundScore = playerRoundScore + die2 + die2 + die3;
				
			}
			if (computerPlaying) {
				computerRoundScore = 0;
				computerPlaying = false;
			}
			return;
		}
			
			
	}
					
			

		
	
	

