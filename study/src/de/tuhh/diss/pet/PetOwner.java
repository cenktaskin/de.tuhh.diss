package de.tuhh.diss.pet;
import de.tuhh.diss.io.SimpleIO;
import java.util.Arrays;

public class PetOwner {
  public static void main(String args[]) {
    Pet[] pets = { new Cat(), new Parrot(), new Cat() };
    for (int i = 0; i < pets.length; i++) {
      care(pets[i]);
    }
  }
  
  public static void care(Pet p) {
    SimpleIO.println("Taking care of pet " + p);
    p.hug();
    p.feed();
    p.hug();
    SimpleIO.println("");
    Arrays.sort();
  }
}
