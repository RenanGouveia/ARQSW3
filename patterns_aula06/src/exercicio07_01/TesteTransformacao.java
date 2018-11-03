package exercicio07_01;

/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


public class TesteTransformacao {
	
	public static void main(String[] args) {
		
		Padrao transf = new Maiusculo();
		transf.processo();
		
		transf = new Minusculo();
		transf.processo();
		
		transf = new Duplicado();
		transf.processo();
		
		transf = new Invertido();
		transf.processo();
		
		
	}

}
