package exercicio01_01;

/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */
public class ClientHelloWorld {
	
	public static void main(String args) {
		ClientHelloWorld client = new ClientHelloWorld();
		
		AbstractWorldPrinterFactory[] factory = {new HelloWorldPrinterFactory(), new GoodbyeWorldPrinterFactory()};
		AbstractWorldPrinterFactory printerFactory = factory[client.sorteio()];
		
		String[] tipos = {HelloWorldPrinterFactory.FILE, HelloWorldPrinterFactory.SCREEN};
		
		WorldPrinter printer = printerFactory.getPrinterInstance(tipos[client.sorteio()]);
		printer.print();
	}
	
	public int sorteio() {
		return (int) Math.round(Math.random());
	}

}
