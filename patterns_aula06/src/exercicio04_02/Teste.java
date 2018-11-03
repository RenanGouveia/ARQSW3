package exercicio04_02;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */

public class Teste {

	public static void main(String[] args) {
		SomadorEsperado somador = new SomadorAdapter();
		Cliente cliente = new Cliente(somador);
		cliente.executar();
	}

}
