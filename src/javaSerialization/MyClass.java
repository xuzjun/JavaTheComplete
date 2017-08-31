package javaSerialization;

import java.io.Serializable;

public class MyClass implements Serializable {
	
	private static final long serialVersionUID = -7108395781422399270L;

	String s;
	int i;
	double d;
	
	public MyClass(String s, int i, double d) {
		this.s = s;
		this.i = i;
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "s = " + s + "; i = " + i + "; d = " + d;
	}
}
