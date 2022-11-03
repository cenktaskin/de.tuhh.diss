package study;

public class Test {
  public static void main(String args[]) {
    Rect r0, r1;
    
    r0 = new Rect(-5, -5, 5, 5);
    
    // case 1 (TR)
    r1 = new Rect(0, 0, 10, 10);
    r0.getIntersection(r1).print();
    
    // case 2 (BR)
    r1 = new Rect(0, 0, 10, -10);
    r0.getIntersection(r1).print();
    
    // case 3 (BL)
    r1 = new Rect(0, 0, -10, -10);
    r0.getIntersection(r1).print();
    
    // case 4 (TL)
    r1 = new Rect(0, 0, -10, 10);
    r0.getIntersection(r1).print();
    
    // case 5 (TR corner match)
    r1 = new Rect(5, 5, 10, 10);
    r0.getIntersection(r1).print();
    
    // case 6 (TR no overlap)
    // NOTE this will cause a runtime error
    // that we will take care of later
//    r1 = new Rect(6, 6, 10, 10);
//    r0.getIntersection(r1).print();
  }
}
