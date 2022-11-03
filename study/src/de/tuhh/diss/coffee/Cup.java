package de.tuhh.diss.coffee;
import de.tuhh.diss.io.SimpleIO;

public class Cup {
  /////////////////////////////////////////////////////////////////////////
  // attributes
  /////////////////////////////////////////////////////////////////////////
  
  public static final int MAX_FILL_LVL = 500;  // [ml]
  private int fillLvl; // [ml]
  
  
  /////////////////////////////////////////////////////////////////////////
  // constructor
  /////////////////////////////////////////////////////////////////////////
  
  public Cup() {
    // we essentially use the constructor to show the call-sequence in case
    // of inheritance. Otherwise, it would not be needed here (fillLvl
    // would be initialized with 0 zero automatically
    printMsg("constructed (empty)");
    fillLvl = 0;
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (public interface)
  /////////////////////////////////////////////////////////////////////////
  
  /**
   * fills a cup with given amount
   *
   * @param amount amount to be filled into cup in ml
   * @return amount actually filled in ml
   */
  public int fill(int amount) {
    if (amount < 0) {
      return 0;
    }
    
    if (amount > MAX_FILL_LVL - fillLvl) {
      amount  = MAX_FILL_LVL - fillLvl;
      fillLvl = MAX_FILL_LVL;
    } else {
      fillLvl += amount;
    }
    
    printMsg("filled "+ amount +"ml up to "+ fillLvl +"ml (MAX "+ MAX_FILL_LVL +"ml)");
    
    return amount;
  }
  
  /**
   * removes a given amount from cup
   *
   * @param amount amount to be removed (drunk) from cup in ml
   * @return amount actually drunk / removed
   */
  public int drink(int amount) {
    if (amount < 0) {
      return 0;
    }
  
    if (amount > fillLvl) {
      amount  = fillLvl;
      fillLvl = 0;
    } else {
      fillLvl -= amount;
    }
    
    printMsg("drunk "+ amount +"ml down to "+ fillLvl +"ml (MAX "+ MAX_FILL_LVL +"ml)");

    return amount;
  }
  
  
  public boolean isEmpty() {
    return fillLvl == 0;
  }
  
  
  public boolean isFull() {
    return fillLvl == MAX_FILL_LVL;
  } 
  
  
  /**
   * simulates shaking a cup; since the cup has no cover, its content is spilled
   */
  public void shake() {
    printMsg("Cup shaken and spilled");
    fillLvl = 0;
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (internal)
  /////////////////////////////////////////////////////////////////////////
  
  private void printMsg(String msg) {
    SimpleIO.println("Cup: "+ msg);
  }
}
