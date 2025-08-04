package machineCoding.snakeAndLadder;

public class Snake{
    private final int head;
    private final int tail;
    public Snake(int head ,int tail){
        this.head = head;
        this.tail = tail;
    }

    public int getHead(){
        return this.head;
    }
    public int getTail(){
        return this.tail;
    }
}
