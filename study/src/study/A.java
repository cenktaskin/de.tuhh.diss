package study;

abstract public class A {
	protected int m;
	
	public A() {
		this(0);
	}
	public A(int m) {
		this.m=m;
	}
	public void reset() {
		m= 0;
	}
	abstract public void inc();
	
	abstract public void dec();
	
	public void print() {
		SimpleIO.println("m="+m);
	}
}

