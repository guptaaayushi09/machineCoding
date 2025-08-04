package machineCoding.snakeAndLadder;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;

    private Game(Builder builder){
        this.board = builder.board;
        this.dice = builder.dice;
        this.players = new LinkedList<>(builder.player);
    }
public void play(){
    while(!isGameOver()){
        Player currentPlayer = players.poll();
        int diceRoll = dice.roll();
        int newPosition = currentPlayer.getPosition()+ diceRoll;
        if(newPosition <= board.getBoardSize()){
            currentPlayer.setPosition(board.getNextPosition(newPosition));
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll +
                                " and moved to position " + currentPlayer.getPosition());
        
        }
        if (currentPlayer.getPosition() == board.getBoardSize()) {
            System.out.println(currentPlayer.getName() + " wins!");
            break;
        }
        
        players.offer(currentPlayer);
    }
}
private boolean isGameOver(){
for(Player player :players){
    if(player.getPosition() == board.getBoardSize()){
        return true;
    }
}
return false;
}

public static class Builder{
private Board board;
private Dice dice;
private Queue<Player> player;

public Builder setPlayers(List<String>playerName){
    this.player = new LinkedList<>();
    for(String s:playerName){
        player.add(new Player(s));
    }
    return this;
  
}

public Builder setBoard(Board board){
    this.board = board;
    return this;
}
public Builder setDice(Dice dice){
    this.dice = dice;
    return this;
} 
public Game build() {
    if (board == null || player == null || dice == null) {
        throw new IllegalStateException("Board, Players, and Dice must be set.");
    }
    return new Game(this);
}

}

}
