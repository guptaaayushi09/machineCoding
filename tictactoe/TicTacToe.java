package machineCoding.tictactoe;

import machineCoding.tictactoe.winningStrategy.DiagonalWinning;
import machineCoding.tictactoe.winningStrategy.RowWinning;
import machineCoding.tictactoe.winningStrategy.Colwinning;
import machineCoding.tictactoe.winningStrategy.WinningStrategy;
import java.util.List;


public class TicTacToe{
    private final Board board;
    private final Player[] players;
    private int currentPlayerIndex;
    private GameStatus status;

    public TicTacToe(Player player1,Player player2, int size){
       List<WinningStrategy> winningStrategies = List.of(new RowWinning(),new Colwinning(),new DiagonalWinning());
       this.board = new Board(size, winningStrategies);
       this.players = new Player[]{player1,player2};
       this.status = GameStatus.IN_PROGRESS;
    }

    public synchronized boolean placeMove(int r, int c){
        if(status != GameStatus.IN_PROGRESS){
        throw new IllegalStateException("Game already finished");
        }
        if(!board.checkValidMove(r,c)){
            throw new IllegalArgumentException("Invalid move.");
        }
    Player currentPlayer = players[currentPlayerIndex];
    board.placeMove(r, c, currentPlayer.getSymbol());
     
    if(board.checkWin(currentPlayer.getSymbol())){
        status = GameStatus.WIN;
        System.out.println(currentPlayer.getName()+"wins!");
    }else if(board.isFull()){
      status = GameStatus.DRAW;
      System.out.println("Draw");
    }else{
        currentPlayerIndex = 1-currentPlayerIndex;
    }
 return true;
    }
    public synchronized void reset(){
        board.reset();
        this.status = GameStatus.IN_PROGRESS;
        this.currentPlayerIndex = 0;
    }
    public GameStatus getStatus(){
        return status;
    }

    public void printBoard(){
        board.print();
    }
}