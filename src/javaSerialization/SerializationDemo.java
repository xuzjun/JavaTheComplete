package javaSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
		
		// object serialization
		try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial"))) {
			
			MyClass object1 = new MyClass("Hello", -7, 2.7e10);
			System.out.println("object1: " + object1);
			
			objOStrm.writeObject(object1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream objectIStrm = new ObjectInputStream(new FileInputStream("serial"))) {
			MyClass object2 = (MyClass)objectIStrm.readObject();
			System.out.println("object2: " + object2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
