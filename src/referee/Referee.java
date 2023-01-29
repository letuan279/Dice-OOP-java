package referee;

import java.util.List;

import dice.Dice;
import player.Player;

public class Referee {
	private List<Player> players;
	
	public Referee(List<Player> players) {
		this.players = players;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player nextPlayer(Player currPlayer) {
		int currPlayerIndex = players.indexOf(currPlayer);
		if(currPlayerIndex == players.size() - 1) {
			return players.get(0);
		}else {
			return players.get(currPlayerIndex + 1);
		}
	}
	
	public boolean calculatePoint(Player currPlayer, Dice dice) {
		currPlayer.roll(dice);
		int point = currPlayer.getCurrPoint();
		if(point == 21) {
			return true; // winner
		}else if(point > 21) {
			currPlayer.setCurrPoint(0);
		}else {	}
		System.out.println(currPlayer.getName() + " has " + currPlayer.getCurrPoint() + " now!!");
		return false;
	}
	
	public void announceWinner(Player currPlayer) {
		System.out.println("The winner is " + currPlayer.getName());
	}
}
