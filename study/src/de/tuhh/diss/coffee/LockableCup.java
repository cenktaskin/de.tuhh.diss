package de.tuhh.diss.coffee;
import de.tuhh.diss.io.SimpleIO;

public class LockableCup extends Cup {
  /////////////////////////////////////////////////////////////////////////
  // constructors
  /////////////////////////////////////////////////////////////////////////

  public LockableCup() {
    // we essentially use the constructor to show the call-sequence for
    // inheritance. Otherwise, it would not be needed here (fillLvl
    // would be initialized with 0 zero automatically
    super();
    
    printMsg("constructed");
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (public interface)
  /////////////////////////////////////////////////////////////////////////
  
  /**
   * shake cup without effect, because the cup has a lock/cover
   */
  public void shake() {
    printMsg("nothing spilled");
  }
  
  
  /////////////////////////////////////////////////////////////////////////
  // methods (internal)
  /////////////////////////////////////////////////////////////////////////
  
  private void printMsg(String msg) {
    SimpleIO.println("LockableCup: "+ msg);
  }
}
