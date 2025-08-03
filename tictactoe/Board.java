package machineCoding.tictactoe;
import machineCoding.tictactoe.winningStrategy.WinningStrategy;
import java.util.List;
public class Board{

   private final Cell[][] grid; 
   private final int size;
   private final int moves;
   List<WinningStrategy> winningStrategis;

    Board(int size, List<WinningStrategy> winningStrategies){
        this.size = size;
        grid = new Cell[size][size];
        this.moves = 0;
        initialise();
        winningStrategis = this.winningStrategis;

    }
   private void initialise(){
   for(int i = 0;i< size;i++){
    for(int j =0;j<size;j++){
        grid[i][j] = new Cell();
    }
}}

   public boolean isFull(){
      return moves == size*size;
   }
   
}
