package machineCoding.tictactoe;

public class TicTacToeDemo {
    public static void main(String[] args){
        Player player1 = new Player("Player 1",Symbol.X);
        Player player2 = new Player("Player 2",Symbol.O);

        TicTacToe ticTacToeGame = new TicTacToe(player1, player2, 3);
            ticTacToeGame.placeMove(0,0);
            ticTacToeGame.printBoard();
    
            ticTacToeGame.placeMove(0, 1);
            ticTacToeGame.printBoard();
    
            ticTacToeGame.placeMove(2, 2);
            ticTacToeGame.printBoard();
    
            ticTacToeGame.placeMove(0, 2);
            ticTacToeGame.printBoard();
    
            ticTacToeGame.placeMove(1, 1);
            ticTacToeGame.printBoard();
    }
}
