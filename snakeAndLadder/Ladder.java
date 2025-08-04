package machineCoding.snakeAndLadder;

public class Ladder {
    final int start;
    final int end;
    Ladder(int start,int end){
        this.start = start;
        this.end = end;
    }
    public int getStart(){
        return this.start;
    }
    public int getEnd(){
        return this.end;
    }
}
