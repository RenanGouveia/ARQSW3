package exercicio06_02;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


public class SortTeste {

	public static void main(String[] args) {

		// Bubble Sort
		Sort metodo = new Bubble();
		int[] v = vetorDesordenado();
		metodo.sort(v);

		System.out.println("Bubble Sort");
		imprimirVetor(v);

		// Insertion Sort
		metodo = new Insertion();
		v = vetorDesordenado();
		metodo.sort(v);

		System.out.println("Insertion Sort");
		imprimirVetor(v);

		// Selection Sort
		metodo = new Selection();
		v = vetorDesordenado();
		metodo.sort(v);

		System.out.println("Insertion Sort");
		imprimirVetor(v);
		
		// Quick Sort
		metodo = new Quick();
		v = vetorDesordenado();
		metodo.sort(v);
		
		System.out.println("Quick Sort");
		imprimirVetor(v);

	}
	
	private static int[] vetorDesordenado() {
		int[] v = { 90, 50, 6, 5, 32, 21, 8, 66, 44, 21, 10, 1 };
		return v;
	}
	
	private static void imprimirVetor(int[] v) {
		for (int i = 0; i < v.length; i++) {
			if (i < v.length - 1) {
				System.out.print(v[i] + " ");
			} else {
				System.out.println(v[i]);
			}
		}
	}

}
