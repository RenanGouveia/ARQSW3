package exercicio07_02;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */



import java.util.Arrays;
import java.util.Comparator;

public class TesteComparator {
	
	public static void main(String[] args) {
		
		Double[] vetor = {2.30, 6.21, 8.28, 2.30, 1.27};
		
		Comparator<Double> comparator = new PontoFlutuanteComparator();
		
		Arrays.sort(vetor, comparator);
		
		System.out.println("Ordenado pelo ponto flutuante:");
		System.out.println(Arrays.toString(vetor));
		
		
	}

}
