package javaBeans;

public class PropertiesDemo {
	
	private double data[];
	
	public void setData(int index, double value) {
		data[index] = value;
	}
	
	public double getData(int index) {
		return data[index];
	}

	public double[] getData() {
		return data;
	}

	public void setData(double[] values) {
		data = new double[values.length];
		System.arraycopy(values, 0, data, 0, values.length);
	}
	
	
}
