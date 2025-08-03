package machineCoding.tictactoe.winningStrategy;

import machineCoding.tictactoe.Board;
import machineCoding.tictactoe.Symbol;

public class DiagonalWinning implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, Symbol symbol) {

        boolean isWinDiagonal = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSymbol(i, i) != symbol) {
                isWinDiagonal = false;
                break;
            }
            if (isWinDiagonal) return true;
        }

        boolean isWinReverseDiagonal = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getSymbol(i, board.getSize() - 1 - i) != symbol) {
                isWinReverseDiagonal = false;
                break;
            }
            if (isWinReverseDiagonal) return true;
        }

        return false;
    }
}