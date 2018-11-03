package exercicio02_02;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


public class TesteProvedores {
	
	public static void main(String[] args) {
		
		FactoryProvedor provFact = new FactoryProvedor();
		
		// Confidencial
		Provedor provedor = provFact.getProvedor("patterns");
		provedor.exibir();
		
		// Publico
		provedor = provFact.getProvedor();
		provedor.exibir();
		
	}

}
