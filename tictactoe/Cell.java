package machineCoding.tictactoe;

public class Cell{
    Symbol symbol;
    Cell(){
   this.symbol = Symbol.EMPTY;
    }
    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }
    public Symbol getSymbol(){
        return this.symbol;
    }
    public boolean isEmpty(){
        return symbol == Symbol.EMPTY;
    }
}