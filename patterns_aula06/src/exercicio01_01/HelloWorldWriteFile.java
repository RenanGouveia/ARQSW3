package exercicio01_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HelloWorldWriteFile implements WorldPrinter {

	@Override
	public void print() {
		File file = new File("hello.txt");
		try {
			
			PrintWriter writer = new PrintWriter(file);
			writer.print("Hello, World!");
			writer.close();
			
		} catch (FileNotFoundException e) {	
			
			e.printStackTrace();
		}
	}

}
