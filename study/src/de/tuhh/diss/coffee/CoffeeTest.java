package de.tuhh.diss.coffee;

public class CoffeeTest {

  public static void main(String[] args) {
    // create new shops
    CoffeeShop s1 = new CoffeeShop("Kaffee im Grünen");
    CoffeeShop s2 = new CoffeeShop("Campus Suite");
    
    // create customer 1
    Customer c = new Customer("Lars");
    
    c.buyCoffee(s1, true, true);  // large, takeAway
    c.drink(100);
    c.drink(400);
    
    c.buyCoffee(s2, false, false);  // small, takeAway
    c.buyCoffee(s1, true, true);  // small, takeAway
    c.drink(400);
    
    
    // create customer 2
    c = new Customer("Christian");
    c.buyCoffee(s2, true, false);  // large, stay
    c.run();
    c.buyCoffee(s2, true, true);  // large, takeAway
    c.run();
  }
}
