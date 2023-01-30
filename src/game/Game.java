package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dice.Dice;
import player.Player;
import player.VPlayer;
import referee.Referee;

public class Game {
	private int playerNumber;
	private int diceNumber;
	private List<Player> players;
	private Referee referee;
	private List<Dice> dieces;
	
	public Game(int playerNumber, int diceNumber) {
		this.playerNumber = playerNumber;
		this.diceNumber = diceNumber;
		this.dieces = new ArrayList<Dice>();
		this.players = new ArrayList<Player>();
		// Set dice data
		for(int i = 1; i <= diceNumber; ++i) {
			this.dieces.add(new Dice(i));
		}
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public int getDiceNumber() {
		return diceNumber;
	}

	public void setDiceNumber(int diceNumber) {
		this.diceNumber = diceNumber;
	}

	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Referee getReferee() {
		return referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	public List<Dice> getDieces() {
		return dieces;
	}

	public void setDieces(List<Dice> dieces) {
		this.dieces = dieces;
	}

	public void run() {
		System.out.println("----------------GAME START----------------");
		Scanner in = new Scanner(System.in);
		
		// get player info
		int botIndex = 1;
		for(int i = 1; i <= playerNumber; ++i) {
			System.out.println("Player " + i);
			System.out.print("Name (enter n to get VPlayer): ");
	        String name = in.nextLine();
	        if(name.equals("n")) {
	        	VPlayer newPlayer = new VPlayer("Bot " + botIndex);
	        	botIndex++;
	        	players.add(newPlayer);
	        	continue;
	        }
	        Player newPlayer = new Player(name);
	        players.add(newPlayer);
		}
		
		// get referee and the first player
		referee = new Referee(players);
		Player currPlayer = players.get(0);
		
		// game loop
		while(true) {
			if(!(currPlayer instanceof VPlayer)) {
				System.out.print("Press enter to roll!");
				String rollCmd = in.nextLine();				
			}
			
			// random dice
			Random r = new Random();
			Dice randomDice = dieces.get(r.nextInt(diceNumber));
			
			// calculate point
			boolean isOver = referee.calculatePoint(currPlayer, randomDice);
			if(isOver) {
				referee.announceWinner(currPlayer);
				for(Player player : players) {
					if(player instanceof VPlayer) {
						if(player != currPlayer) {
							((VPlayer) player).loseBehavior();
						}
					}
				}
				break;
			}
			
			// the next player
			currPlayer = referee.nextPlayer(currPlayer);
		}
		
		in.close();
	}
}
