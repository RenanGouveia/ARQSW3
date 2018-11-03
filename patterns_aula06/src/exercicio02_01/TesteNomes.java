package exercicio02_01;



public class TesteNomes {
	

/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		FactoryNome factNS = new FactoryNomeSobrenome();
		FactoryNome factSN = new FactorySobrenomeNome();
		
		String renag = "Gouveia, Renan";
		String renand = "Renan Dutra";
		String renans = "Silva, Renan";
		
		Nome nomeScott = factSN.getNome(renag);
		Nome nomeJames = factNS.getNome(renand);
		Nome nomePatrick = factSN.getNome(renans);
		
		factNS.listarNomes();
		factSN.listarNomes();
		
	}
}
