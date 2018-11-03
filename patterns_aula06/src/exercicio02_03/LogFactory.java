package exercicio02_03;


public class LogFactory {
	
	public Log getLog(String log) {
		if (log.equals("Arquivo")) {
			return new ArquivoLog();
		} else if (log.equals("Console")) {
			return new ConsoleLog();
		}
		return null;
	}

}
