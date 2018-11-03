package exercicio07_01;

public class Invertido extends Padrao {

	@Override
	String transforma(String s) {
		return new StringBuilder(s).reverse().toString();
	}

}