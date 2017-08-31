package javaIO;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		File f1 = new File("E:/t0.sh");
		
		System.out.println("File name: " + f1.getName());
		System.out.println("Path: " + f1.getPath());
		System.out.println("Abs Path: " + f1.getAbsolutePath());
		System.out.println("Parent: " + f1.getPath());
		System.out.println(f1.exists() ? "exists" : "does not exist");
		
	}

}
