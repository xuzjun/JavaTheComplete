package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) {
		int size;

		// auto close file
		try (FileInputStream f = new FileInputStream(
				"E:/java/workspace/JavaTheComplete/src/javaIO/FileInputStreamDemo.java")) {
			System.out.println("Total avaiable bytes: " + (size = f.available()));

			int n = size / 40;

			System.out.println("First " + n + " Bytes of the file on read() at a time");
			for (int i = 0; i < n; i++) {
				System.out.print((char) f.read());
			}

			System.out.println("\nStill Avaliable: " + f.available());
			System.out.println("Reading the next " + n + " with one read(b[])");
			byte b[] = new byte[n];
			if (f.read(b) != n) {
				System.out.println("couldn't red " + n + " bytes");
			}

			System.out.println(new String(b, 0, n));
			System.out.println("\nStill Available: " + (size = f.available()));
			System.out.println("Skipping half of remaining bytes with skip()");
			f.skip(size / 2);
			System.out.println("Still Available: " + f.available());

			System.out.println("Reading " + n / 2 + " into the end of array");
			if (f.read(b, n / 2, n / 2) != 2) {
				System.err.println("couldn't read " + n / 2 + " bytes.");
			}

			System.out.println(new String(b, 0, b.length));
			System.out.println("\nStill Available: " + f.available());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
