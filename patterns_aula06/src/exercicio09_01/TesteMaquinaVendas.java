package exercicio09_01;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */



public class TesteMaquinaVendas {
	
	public static void main(String[] args) {
		
		EntradasChain chain1cent = new Entrada1Centavos();
		EntradasChain chain5cent = new Entrada5Centavos();
		EntradasChain chain10cent = new Entrada10Centavos();
		EntradasChain chain25cent = new Entrada25Centavos();
		EntradasChain chain50cent = new Entrada50Centavos();
		EntradasChain chain1real = new Entrada1Real();
		
		chain1cent.setNextChain(chain5cent);
		chain5cent.setNextChain(chain10cent);
		chain10cent.setNextChain(chain25cent);
		chain25cent.setNextChain(chain50cent);
		chain50cent.setNextChain(chain1real);
		
		Produto refri = new Produto("Refrigerante", 1.00);
		Produto batatinhas = new Produto("Batata", 2.50);
		
		Moeda m1c = new Moeda(0.01);
		Moeda m5c = new Moeda(0.05);
		Moeda m10c = new Moeda(0.10);
		Moeda m25c = new Moeda(0.25);
		Moeda m50c = new Moeda(0.50);
		Moeda m1r = new Moeda(1.00);
		
		chain1cent.calcula(m5c, refri);
		chain1cent.calcula(m10c, refri);
		chain1cent.calcula(m25c, refri);
		chain1cent.calcula(m25c, refri);
		chain1cent.calcula(m1r, refri);
		
		chain1cent.calcula(m1c, batatinhas);
		chain1cent.calcula(m50c, batatinhas);
		chain1cent.calcula(m1r, batatinhas);
		chain1cent.calcula(m50c, batatinhas);
		chain1cent.calcula(m25c, batatinhas);
		chain1cent.calcula(m25c, batatinhas);
	
	}

}
