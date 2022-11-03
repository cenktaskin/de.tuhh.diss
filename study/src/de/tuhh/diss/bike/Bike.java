package de.tuhh.diss.bike;
import de.tuhh.diss.io.SimpleIO;
import java.util.Arrays;

public class Bike implements Comparable<Bike> {
  String brand;
  int price;
  
  public Bike(String brand, int price) {
    this.brand = brand;
    this.price = price;
  }
  
  public void print() {
    SimpleIO.println(brand + ", " + price);
  }
  
  public int compareTo(Bike o) {
    if (price < o.price) {
      return -1;
    } else if (price > o.price) {
      return 1;
    } else {
      return brand.compareTo(o.brand);
    }
  }
  
  public static void main(String[] args) {
    Bike[] bikes = {
      new Bike("Canyon", 1499),
      new Bike("Rose", 1399),
      new Bike("On-One", 999),
      new Bike("On-One", 1399)
    };
    
    Arrays.sort(bikes);
    for (int i = 0; i < bikes.length; i++) {
      bikes[i].print();
    }
  }
}
