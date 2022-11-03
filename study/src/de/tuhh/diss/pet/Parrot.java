package de.tuhh.diss.pet;
import de.tuhh.diss.io.SimpleIO;

public class Parrot implements Pet {
  // ...
  public void feed() {
    SimpleIO.println("Parrot: squawk");
  }
  
  public void hug() {
    SimpleIO.println("[Parrot escapes]");
  }
}
