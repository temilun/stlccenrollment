/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

/**
 *
 * @author Jonathan
 */
public class Item implements java.io.Serializable{
    public String productCode;
    public String description;
    public double price;

    public Item()
    {
    }

    public Item(String aProductCode, String aDescription,
        double aPrice, int aQuantity)
    {
        productCode = aProductCode;
        description = aDescription;
        price = aPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
