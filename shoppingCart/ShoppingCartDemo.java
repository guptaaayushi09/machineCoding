package shoppingCart;
import java.util.*;

import shoppingCart.Exceptions.CartSizeExceededException;
import shoppingCart.Exceptions.OutOfStockException;
import shoppingCart.Exceptions.EmptyCartException;

public class ShoppingCartDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int maxCartSize = Integer.parseInt(sc.nextLine().trim());
        ShoppingCart cart = new ShoppingCart(maxCartSize);
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int i = 0;i<n;i++){
            String[] parts = sc.nextLine().trim().split(",");
            String name = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());
            boolean inStock = Boolean.parseBoolean(parts[2].trim());

            ShoppingItem item = new ShoppingItem(name, price, inStock);
            try{
                System.out.println(cart.addItem(item));
            }catch(OutOfStockException | CartSizeExceededException e){
                System.out.println(e.getMessage());
            }

        }
        int o = Integer.parseInt(sc.nextLine().trim());

        for(int i = 0;i<o;i++){
            String op = sc.nextLine().trim();
            if(op.equalsIgnoreCase("viewCart")){
                System.out.println(cart.viewCart());
            }else if(op.equalsIgnoreCase("checkout")){
               try{
                System.out.println(cart.checkout());
               } catch(EmptyCartException e){
                System.out.println(e.getMessage());
               }
            }

        }
        sc.close();
    }
}
