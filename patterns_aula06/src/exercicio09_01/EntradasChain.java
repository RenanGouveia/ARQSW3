package exercicio09_01;

public interface EntradasChain {
	
	void setNextChain(EntradasChain nextChain);
	void calcula(Moeda moeda, Produto produto);

}
