package de.tuhh.diss.button;

public class Test {
  public static void main(String args[]) {
    Button btnRed = new Button("red");
    Button btnBlue = new Button("blue");
    
    Messenger m1 = new Messenger("BOING");
    Messenger m2 = new Messenger("TADA");
    
    btnRed.addButtonListener(m1);
    btnBlue.addButtonListener(m1);
    btnBlue.addButtonListener(m2);
    
    btnRed.press();
    btnBlue.press();
    btnRed.press();
  }
}
