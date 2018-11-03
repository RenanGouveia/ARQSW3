package exercicio07_01;

import java.util.Scanner;

public abstract class Padrao {
	
	public final void processo() {
		String s = lerString();
		String st = transforma(s);
		printa(st);
	}
	
	abstract String transforma(String s);
	
	@SuppressWarnings("resource")
	final String lerString() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insira a string: ");
		String s = scanner.next();
		return s;
	}
	
	final void printa(String st) {
		System.out.print(st + "\n");
	}
	

}
