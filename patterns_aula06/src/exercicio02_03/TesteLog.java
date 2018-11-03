package exercicio02_03;

/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


public class TesteLog {
	
	public static void main(String[] args) {
		
		// "Contando ate 10"
		int[] numeros = new int[10];
		for (int i = 0; i < 10; i++) {
			numeros[i] = i + 1;
		}
		
		LogFactory logfact = new LogFactory();
		
		Log log = logfact.getLog("Arquivo");
		log.efetuar(numeros);
		
		log = logfact.getLog("Console");
		log.efetuar(numeros);
		
	}

}
