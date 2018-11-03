package exercicio08_01;

public class Consumidor implements ConsomeNoticia {
	private final Noticiario estadao;	
	private String assinante;
	
	public  Consumidor(Noticiario noticiario,String assinante) {
		this.estadao=noticiario;
		this.assinante=assinante;
	}
	
	@Override
	public void consomeNoticia(String textoNoticia, int dia, int mes, String topico) {
		System.out.printf("Texto: %s\nData: %d/%d\nTopico: %s \n",textoNoticia,dia,mes,topico);

	}

	@Override
	public void assinar() {
		estadao.inscreverConsumidor(this);
		
	}

	@Override
	public void cancelar() {
		estadao.removerConsumidor(this);
		
	}
	@Override
	public String getAssinante() {
		return this.assinante;
	}

}
