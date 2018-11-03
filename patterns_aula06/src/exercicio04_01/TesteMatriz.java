package exercicio04_01;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TesteMatriz {
	
	public static void main(String[] args) {
		
		int[][] matriz = {
				{3, 5, 7},
				{5, 4, 9}
		};
		
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> map = new MatrizAdapter(matriz);
		
		StringBuilder sb = new StringBuilder();
	    Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
	    while (iter.hasNext()) {
	        Entry<Integer, Integer> entry = iter.next();
	        sb.append(entry.getKey());
	        sb.append('=').append('"');
	        sb.append(entry.getValue());
	        sb.append('"');
	        if (iter.hasNext()) {
	            sb.append(',').append(' ');
	        }
	    }
	    System.out.println(sb.toString());
		
	}
}
