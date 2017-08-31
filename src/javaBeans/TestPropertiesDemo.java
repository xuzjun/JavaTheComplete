package javaBeans;

public class TestPropertiesDemo {

	public static void main(String[] args) {
		PropertiesDemo pd = new PropertiesDemo();
		
		double data[] = new double[5];
		
		data[0] = 0;
		data[1] = 1;
		data[2]	= 2;
		data[3] = 3;
		data[4] = 4;
		
		pd.setData(data);
		
		data[3] = 5;
		
		System.out.println("data[3]: " + pd.getData(3));
		
	}

}
