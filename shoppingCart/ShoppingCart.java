package shoppingCart;
import java.util.*;

import shoppingCart.Exceptions.CartSizeExceededException;
import shoppingCart.Exceptions.OutOfStockException;
import shoppingCart.Exceptions.EmptyCartException;

public class ShoppingCart implements CartOperations{
    private List<ShoppingItem> items;
    private int maxCartSize;

    public ShoppingCart(int maxCartSize){
        this.maxCartSize = maxCartSize;
        items = new ArrayList<>();
    }

    @Override
    public String addItem(ShoppingItem item) throws OutOfStockException, CartSizeExceededException{
        try{
            if(!item.isInStock()){
                throw new OutOfStockException(item.getName());
            }
            if(items.size() >= maxCartSize){
                throw new CartSizeExceededException(maxCartSize);
            }
            items.add(item);
            return item.getName() + " added successfully";
        }catch(OutOfStockException | CartSizeExceededException e ){
            throw e;
        }
    }
    @Override
    public String viewCart(){
        if(items.isEmpty()){
            return "Cannot view an empty cart.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Items in the cart: \n");
        double total = 0;
        for(ShoppingItem item : items){
            sb.append("- ").append(item.getItemDetails()).append("\n");
            total += item.getPrice();
        }
        sb.append("Total cost: $").append(String.format("%.2f",total));
        return sb.toString();
    }

    @Override 
    public String checkout() throws EmptyCartException {
        try{
            if(items.isEmpty()){
                throw new EmptyCartException();
            }
            return "Checkout completed successfully.";
        }catch (EmptyCartException e){
            throw e;
        }
    }
}
