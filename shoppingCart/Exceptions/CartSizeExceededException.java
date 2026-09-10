package shoppingCart.Exceptions;

public class CartSizeExceededException extends Exception{
    public CartSizeExceededException(int cartSize){
        super("Cannot add item to the cart as it will exceed the maximum cart size of "+ cartSize+".");
    }
}