package de.tuhh.diss.ticket;
import de.tuhh.diss.io.SimpleIO;

public class TicketMachineTest {
  public static void main(String[] args) {    
    SimpleIO.print("Enter price of ticket: ");
    int price = SimpleIO.readInteger();
    TicketMachine tm = new TicketMachine(price);
    
    SimpleIO.print("Enter amount of money: ");
    int budget = SimpleIO.readInteger();
    
    tm.insertMoney(budget);
    int numTickets = 0;
    while (tm.getBalance() >= tm.getTicketPrice()) {
      tm.printTicket();
      numTickets++;
    }
    
    price = tm.getTicketPrice();
    int refund = tm.refundBalance();
    SimpleIO.println(
      "budget = "+ budget +
      ", numTickets = "+ numTickets +
      ", price = "+ price +
      ", refund = "+ refund);
    if (budget == (numTickets * price + refund)) {
      SimpleIO.println("## PASSED ##");
    } else {
      SimpleIO.println("## FAILED ##");
    }
  }
}
