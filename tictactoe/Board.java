package machineCoding.tictactoe;

import machineCoding.tictactoe.winningStrategy.WinningStrategy;
import java.util.List;

public class Board {

    private final Cell[][] grid;
    private final int size;
    private final int moves;
    List<WinningStrategy> winningStrategis;

    Board(int size, List<WinningStrategy> winningStrategies) {
        this.size = size;
        grid = new Cell[size][size];
        this.moves = 0;
        initialise();
        this.winningStrategis = winningStrategies;
    }

    private void initialise() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }
    public boolean checkValidMove(int r, int c){
        return r>=0 && c >=0 && r<size  && c<size && grid[r][c].isEmpty();
    }
  public void placeMove(int r,int c,Symbol symbol){
    grid[r][c].setSymbol(symbol);
  }
    public void reset(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j].setSymbol(Symbol.EMPTY);
            }
        }
    }
    public boolean isFull() {
        return moves == size * size;
    }
    public int getSize(){
        return this.size;
    }
    public Symbol getSymbol(int row, int col) {
        return grid[row][col].getSymbol();
    }
    public boolean checkWin(Symbol symbol){
     for(WinningStrategy strategies : winningStrategis){
        if(strategies.checkWinner(this, symbol)){
            return true;
        }
     }
     return false;
    }
    public void print(){
        for(int i =0;i<size;i++){
            for(int j =0;j<size;j++){
                System.out.println(grid[i][j].getSymbol()+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
