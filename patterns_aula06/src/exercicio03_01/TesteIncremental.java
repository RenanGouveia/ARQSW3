package exercicio03_01;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


public class TesteIncremental {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Incremental inc = Incremental.getInstanceOff();
			inc.incrementa();
			System.out.println(inc);
		}
	}
	
}
