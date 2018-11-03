package exercicio02_02;


public class FactoryProvedor {
	
	public Provedor getProvedor(String senha) {
		if (senha.equals("patterns")) {
			return new ProvedorConfidencial();
		}
		// Se a senha for incorreta, retorna publico
		return new ProvedorPublico();
	}
	
	public Provedor getProvedor() {
		return new ProvedorPublico();
	}

}
