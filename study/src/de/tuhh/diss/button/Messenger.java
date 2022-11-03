package de.tuhh.diss.button;
import de.tuhh.diss.io.SimpleIO;

public class Messenger implements ButtonListener {
  private String msg;
  
  public Messenger(String msg) {
    this.msg = msg;
  }
  
  public void buttonPressed(Button b) {
    SimpleIO.println(msg +" for button "+ b.getName());
  }
}
