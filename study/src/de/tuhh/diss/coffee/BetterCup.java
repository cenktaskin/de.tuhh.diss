package de.tuhh.diss.coffee;
import de.tuhh.diss.io.SimpleIO;

// NOTE this is intended to be a replacement for Cup, so
// the class goes by the name Cup (rather than BetterCup,
// which is the filename).
// Copy this over Cup.java for testing
public class Cup {
  /* attributes */
  public static final int MAX_FILL_LVL = 500;  // [ml]
  private int fillLvl;
  
  
  /* constructor */
  public Cup() {
    printMsg("constructed (empty)");
    fillLvl = 0;
  }
  
  
  /* methods (public interface) */
  public int fill(int amount) {
    if (amount < 0) {
      return 0;
    }
  
    return changeFillLvl(amount);
  }
  
  public int drink(int amount) {
    if (amount < 0) {
      return 0;
    }
  
    return changeFillLvl(-amount);
  }
  
  public boolean isEmpty() {
    return fillLvl == 0;
  }
  
  public boolean isFull() {
    return fillLvl == MAX_FILL_LVL;
  } 
  
  public void shake() {
    printMsg("Cup shaken and spilled");
    fillLvl = 0;
  }
  
  
  /* methods (internal) */
  private void printMsg(String msg) {
    SimpleIO.println("Cup: "+ msg);
  }
  
  private int changeFillLvl(int amount) {
    fillLvl += amount;
    
    if (fillLvl > MAX_FILL_LVL) {
      amount -= fillLvl - MAX_FILL_LVL;
      fillLvl = MAX_FILL_LVL;
    } else if (fillLvl < 0) {
      amount += fillLvl;
      fillLvl = 0;
    }
    
    if (amount > 0) {
      printMsg("filled "+ amount +"ml up to "+ fillLvl +"ml (MAX "+ MAX_FILL_LVL +"ml)");
    } else {
      printMsg("drunk "+ amount +"ml down to "+ fillLvl +"ml (MAX "+ MAX_FILL_LVL +"ml)");
    }
    
    return amount;
  }
}
