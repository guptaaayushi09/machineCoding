package machineCoding.tictactoe.winningStrategy;
import machineCoding.tictactoe.Board;
import machineCoding.tictactoe.Symbol;

public class Colwinning implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board,Symbol symbol){
        for(int i =0;i<board.getSize();i++){
            boolean isWin = true;
            for(int j =0;j< board.getSize();j++){
             if(board.getSymbol(j,i) != symbol){
               isWin = false;
               break;
             }
            }
            if(isWin) return true;
            }
    return false;
    }
}