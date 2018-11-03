package exercicio08_02;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */
 

public class TesteNoticias {
	
	public static void main(String[] args) {
		
		NoticiarioAssina not = new NoticiarioAssina();
		ConsomeNoticia pub = new Publicador();
		Agregador agrTop = new AgregadorTopico("Programa��o");
		Agregador agrMes = new AgregadorMes();
		
		not.adicionaConsumidor(pub);
		not.adicionaConsumidor(agrTop);
		not.adicionaConsumidor(agrMes);
		
		agrTop.adicionaConsumidor(pub);
		agrMes.adicionaConsumidor(pub);
		
		
		not.notificaNoticia("Universidades apostam em Python como linguagem de programa��o sensa��o.", 6, 5, "Programa��o");
		not.notificaNoticia("Hackaton S�o Judas � um sucesso.", 31, 5, "Programa��o");
		not.notificaNoticia("Bradesco lan�a programa para StartUps", 20, 6, "Programa��o");

	
	}

}
