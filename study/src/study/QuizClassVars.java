package study;

public class QuizClassVars {
  private static int classVar = 0;
  private int instVar;
 
  public QuizClassVars() {
    instVar = ++classVar;
  }
  
  public static void main(String[] args) {
    QuizClassVars a, b, c;
    a = new QuizClassVars();
    a.print();
    a = new QuizClassVars();
    a.print();
  }
  
  public void print() {
    SimpleIO.println(instVar +" of "+ classVar);
  }
}
