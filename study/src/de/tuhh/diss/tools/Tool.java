package de.tuhh.diss.tools;
import de.tuhh.diss.io.SimpleIO;

abstract public class Tool {
  private String brand;
  private int weight;
  
  public Tool(String brand, int weight) {
    this.brand = brand;
    this.weight = weight;
  }
  
  public Tool() {
    this("none", 0);
  }
  
  public void explain() {
    SimpleIO.println("By >"+ brand +"< with weight "+ weight +"g");
  }
  
  // this forces all derived classes to implement apply()
  // and enables its call for Tool-superclass references
  abstract public void apply();
}
