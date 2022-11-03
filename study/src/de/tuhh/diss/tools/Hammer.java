package de.tuhh.diss.tools;
import de.tuhh.diss.io.SimpleIO;

public class Hammer extends Tool {
  private String material;
  
  public Hammer() {
    material = "air";
  }
  
  public Hammer(String brand, int weight, String material) {
    super(brand, weight);
    this.material = material;
  }
  
  public void explain() {
    SimpleIO.println("This is a HAMMER made of "+ material);
    super.explain();
  }
  
  public void apply() {
    SimpleIO.println("hammer ... hammer ... ouch");
  }
}
