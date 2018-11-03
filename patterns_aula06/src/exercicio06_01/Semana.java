package exercicio06_01;


public class Semana {
	private final DiaDaSemana dia;
	
	public Semana(DiaDaSemana dia) {
		this.dia=dia;
	}
	
	public void imprimeDia() {
		System.out.println(dia.dia());
	}
	
}
