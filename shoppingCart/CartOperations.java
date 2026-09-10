package shoppingCart;

import shoppingCart.Exceptions.*;

public interface CartOperations{
    String addItem(ShoppingItem item) throws OutOfStockException,CartSizeExceededException;
    String viewCart();
    String checkout() throws EmptyCartException;
}