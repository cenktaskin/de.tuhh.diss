package de.tuhh.diss.tools;
import de.tuhh.diss.io.SimpleIO;

public class Saw extends Tool {
  private String blade;
  
  public Saw() {
    blade = "nothing";
  }
  
  public Saw(String brand, int weight, String blade) {
    super(brand, weight);
    this.blade = blade;
  }
  
  public void explain() {
    SimpleIO.println("This is a SAW with a blade for "+ blade);
    super.explain();
  }
  
  public void apply() {
    SimpleIO.println("saw ... saw ... saw");
  }
}
