package de.tuhh.diss.pet;
import de.tuhh.diss.io.SimpleIO;

public class Cat implements Pet {
  // ...
  public void feed() {
    SimpleIO.println("Cat: meow");
  }
  
  public void hug() {
    SimpleIO.println("[Cat scratches]");
  }
}
