package study;

public class Rect {
  private CoordXY p0;  // bottom left
  private CoordXY p1;  // top right

  public Rect(int x0, int y0, int x1, int y1) {
    p0 = new CoordXY(
      Math.min(x0, x1),
      Math.min(y0, y1));
    p1 = new CoordXY(
      Math.max(x0, x1),
      Math.max(y0, y1));
  }
  
  public Rect(CoordXY p0, CoordXY p1) {
    // NOTE this will create new points
    this(
      p0.getX(), p0.getY(),
      p1.getX(), p1.getY());
  }

  public Rect getIntersection(Rect rect) {
    int x0, y0, x1, y1;
    // assumes that p0 is BL and p1 is TR
    x0 = Math.max(p0.getX(), rect.p0.getX());
    y0 = Math.max(p0.getY(), rect.p0.getY());
    x1 = Math.min(p1.getX(), rect.p1.getX());
    y1 = Math.min(p1.getY(), rect.p1.getY());
    if (x0 > x1 || y0 > y1) {
      return null; // no intersect / overlap
    }
    return new Rect(x0, y0, x1, y1);
  }
  
  public void print() {
    SimpleIO.println("rect"
      + " BL("+p0.getX()+","+p0.getY()+")"
      + " TR("+p1.getX()+","+p1.getY()+")");
  }
}
