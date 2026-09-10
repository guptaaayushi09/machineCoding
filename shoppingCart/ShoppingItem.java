package shoppingCart;

public class ShoppingItem {
    private String name;
    private double price;
    private boolean inStock;

    public ShoppingItem(String name, double price, boolean inStock){
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public boolean isInStock(){
        return this.inStock;
    }
    public String getItemDetails(){
        return name + " (Price: $" +price +", In Stock:" + inStock+ ")";
    }

}
