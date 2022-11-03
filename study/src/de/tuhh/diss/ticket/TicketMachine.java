package de.tuhh.diss.ticket;
import  de.tuhh.diss.io.SimpleIO;

public class TicketMachine {
  private int ticketPrice;
  private int balance;
  private int revenue;

  public TicketMachine(int ticketPrice) {
    this.ticketPrice = ticketPrice;
    balance = 0;
    revenue = 0;
  }
  
  public int getTicketPrice() {
    return ticketPrice;  
  }

  public int getBalance() {
    return balance;  
  }

  public void insertMoney(int amount) {
    // ignore illegal input for now
    if (amount > 0) {
      balance += amount;
    }
  }

  public void printTicket() {
    if (balance >= ticketPrice) {
      SimpleIO.println("## Ticket ##");
      revenue += ticketPrice;
      balance -= ticketPrice;
    } else {
      SimpleIO.println("Ticket price: "
        + ticketPrice + ", missing " +
        + (ticketPrice - balance) + " cents.");           
    }  
  }
  
  public int refundBalance() {
    int amountToRefund = balance;
    balance = 0;
    return amountToRefund;  
  }
}
