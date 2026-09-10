package shoppingCart.Exceptions;

public class EmptyCartException extends Exception{
    public EmptyCartException(){
        super("Cannot complete checkout as the cart is empty.");
    }
}