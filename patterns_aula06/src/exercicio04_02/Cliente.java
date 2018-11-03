
package exercicio04_02;



/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


public class Cliente {
	private SomadorEsperado somador;

	public Cliente(SomadorEsperado somador) {
		this.somador = somador;
	}
	public void executar() {
		int[] vetor = new int[] { 0, 6, 20, 4, 5, 6, 7, 8, 9, 11 };
		int soma = somador.somaVetor(vetor);
		System.out.println("Resultado: " + soma);
	}
}
