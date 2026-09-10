package shoppingCart.Exceptions;

public class OutOfStockException extends Exception{
    public OutOfStockException(String itemName){
        super("Cannot add item '"+ itemName+"' to the cart as it is out of stock.");
    }
}