package machineCoding.snakeAndLadder;

public class Dice {
    private final int minValue;
    private final int maxValue;
    Dice(int minValue,int maxValue){
        this.minValue= minValue;
        this.maxValue = maxValue;
    }

    public int roll(){
        return (int)(Math.random() *(maxValue - minValue +1) + minValue);
    }
}
