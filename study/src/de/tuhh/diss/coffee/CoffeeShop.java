package de.tuhh.diss.coffee;
import de.tuhh.diss.io.SimpleIO;

public class CoffeeShop {
  /////////////////////////////////////////////////////////////////////////
  // attributes
  /////////////////////////////////////////////////////////////////////////
  
  private String name;
  
  
  /////////////////////////////////////////////////////////////////////////
  // constructors
  /////////////////////////////////////////////////////////////////////////
  
  public CoffeeShop(String name) {
    this.name = name;
    
    SimpleIO.println("new coffee shop "+ name);
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (public interface)
  /////////////////////////////////////////////////////////////////////////
  
  /**
   * make a coffee and return the (filled) cup.
   *
   * @param large true -> fully-filled cup, false -> half-filled
   * @param takeAway true -> lockable cup, false -> cup 
   *
   * @return the filled cup (can be either Cup or LockableCup)
   */
  public Cup makeCoffee(boolean large, boolean takeAway) {
    printNewOrder(large, takeAway);
  
    Cup cup;
    if (takeAway) {
      cup = new LockableCup();
    } else {
      cup = new Cup();
    }
    
    if (large) {
      cup.fill(Cup.MAX_FILL_LVL);
    } else {
      cup.fill(Cup.MAX_FILL_LVL / 2);
    }
    
    return cup;
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (internal)
  /////////////////////////////////////////////////////////////////////////
  
  private void printNewOrder(boolean large, boolean takeAway) {
    String msg = "new order for";
    
    if (large) {
      msg += " full";
    } else {
      msg += " half";
    }
    
    msg += " coffee";
    
    if (takeAway) {
      msg += " to go";
    } else {
      msg += " to stay";
    }
    
    SimpleIO.println(name +": "+ msg);
  }
}
