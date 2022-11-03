package de.tuhh.diss.coffee;
import de.tuhh.diss.io.SimpleIO;

public class Customer {
  /////////////////////////////////////////////////////////////////////////
  // attributes
  /////////////////////////////////////////////////////////////////////////
  
  private String name;
  private Cup cup;
  
  
  /////////////////////////////////////////////////////////////////////////
  // constructors
  /////////////////////////////////////////////////////////////////////////
  
  /**
   * initialize customer with name and leave cup empty (has to be bought
   * explicitly)
   */
  public Customer(String name) {
    this.name = name;
    cup = null;
    
    printMsg("new customer without coffee");
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (public interface)
  /////////////////////////////////////////////////////////////////////////
  
  /**
   * buy a new coffee from shop. Only possible, if customer has no cup yet.
   *
   * @param shop reference to shop from which coffee shall be bought
   * @param large true for large coffee, false for small one
   * @param takeWay true to take coffee away, false for staying in the shop
   *
   * @return true, if a new coffee was bought; false otherwise
   */
  public boolean buyCoffee(CoffeeShop shop, boolean large, boolean takeAway) {
    if (cup == null) {
      printMsg("Time for Coffee");
      cup = shop.makeCoffee(large, takeAway);
      return true;
    } else {  
      printMsg("I already have a coffee");
      return false;
    }
  }
  
  
  /**
   * drink from cup
   *
   * @param amount amount to be drunk from cup
   */
  public void drink(int amount) {
    if (cup == null) {
      printMsg("I don't have no coffee!");
      return;
    }
    
    // NOTE we could also check amount here, but leave it to the cup
    
    printMsg("Want to drink "+ amount +"ml");
    amount = cup.drink(amount);
    printMsg("Got "+ amount +"ml");
    
    checkEmpty();
  }
  
  
  
  /**
   * simulates a running customer who (accidentally) shakes the cup
   */
  public void run() {
    printMsg("I'm late, better run.");
  
    if (cup != null) {
      cup.shake();
    }
    
    checkEmpty();
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (internal)
  /////////////////////////////////////////////////////////////////////////
  
  /**
   * check if a cup is empty and delete the reference in that case
   */
  private void checkEmpty() {
    if (cup == null) {
      return;
    } else if (cup.isEmpty()) {
      printMsg("Cup is empty, thrown away. :-(");
      cup = null;
    }
  }
  
  
  private void printMsg(String msg) {
    SimpleIO.println(name +": "+ msg);
  }
}
