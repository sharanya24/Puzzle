package com.pramati.puzzle;

/**
 * @author sharanyak
 *
 */
public class Item {
  private String itemName;
  private Float price;
  
  
  public Item(String itemName){
    
    this.itemName = itemName;
    
  }
  
  public Item(String itemName, Float price) {
    super();
    this.itemName = itemName;
    this.price = price;
  }
  
  
  public String getItemName() {
    return itemName;
  }
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }
  @Override
  public String toString() {
    return "Item [itemName=" + itemName + ", price=" + price + "]";
  }
  
  
  

}
