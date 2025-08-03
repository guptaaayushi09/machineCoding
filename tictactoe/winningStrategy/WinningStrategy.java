package machineCoding.tictactoe.winningStrategy;
import machineCoding.tictactoe.Board;
import machineCoding.tictactoe.Symbol;

public interface WinningStrategy {
boolean checkWinner(Board board,Symbol symbol);   
} 
