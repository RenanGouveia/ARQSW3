package exercicio08_02;

public class Publicador implements ConsomeNoticia {

	@Override
	public void notificaNoticia(String textoNoticia, int dia, int mes, String topico) {
		System.out.println("Topico: " + topico + ", data: " + dia + "/" + mes);
		System.out.println(textoNoticia + "\n");
	}

}
