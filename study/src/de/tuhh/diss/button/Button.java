package de.tuhh.diss.button;

public class Button {
  public static final int MAX_BTN_LISTEN = 10;
  private ButtonListener[] bl;
  private String name;
  
  public Button(String name) {
    bl = new ButtonListener[MAX_BTN_LISTEN];
    this.name = name;
  }
  
  public String getName() {
    return name;
  }

  public boolean addButtonListener(ButtonListener l) {
    for (int i = 0; i < bl.length; i++) {
      if (bl[i] == null) {
        bl[i] = l;
        return true;
      }
    }
    return false;
  }
  
  public void press() {
    for (int i = 0; i < bl.length; i++) {
      if (bl[i] != null) {
        bl[i].buttonPressed(this);
      }
    }
  }
}
