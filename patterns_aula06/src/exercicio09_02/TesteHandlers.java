package exercicio09_02;


/* Nome: Renan Gouveia Dutra da Silva
 * RA: 816114946
 */


import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TesteHandlers {

	public static void main(String[] args) {

		HandlerChain handler1 = new Handler(1);
		HandlerChain handler2 = new Handler(2);
		HandlerChain handler3 = new Handler(3);
		HandlerChain handler4 = new Handler(4);
		HandlerChain handler5 = new Handler(5);
		HandlerChain handler6 = new Handler(6);
		HandlerChain handler7 = new Handler(7);
		HandlerChain handler8 = new Handler(8);
		HandlerChain handler9 = new Handler(9);
		HandlerChain handler10 = new Handler(10);
		HandlerChain handler11 = new Handler(11);
		HandlerChain handler12 = new Handler(12);
		HandlerChain handler13 = new Handler(13);
		HandlerChain handler14 = new Handler(14);
		HandlerChain handler15 = new Handler(15);

		handler1.setNextChain(handler2);
		handler2.setNextChain(handler3);
		handler3.setNextChain(handler4);
		handler4.setNextChain(handler5);
		handler5.setNextChain(handler6);
		handler6.setNextChain(handler7);
		handler7.setNextChain(handler8);
		handler8.setNextChain(handler9);
		handler9.setNextChain(handler10);
		handler10.setNextChain(handler11);
		handler11.setNextChain(handler12);
		handler12.setNextChain(handler13);
		handler13.setNextChain(handler14);
		handler14.setNextChain(handler15);
		
		// 5 requisicoes
		for (int i = 0; i < 5; i++) {
			handler1.handleRequest(ThreadLocalRandom.current().nextInt(0, 10000 + 1));
		}
		
		// Espera 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		// Outras 16 Requisicoes (todos irao ficar ocupados e a ultima sera cancelada
		for (int i = 0; i < 16; i++) {
			handler1.handleRequest(ThreadLocalRandom.current().nextInt(0, 10000 + 1));
		}
		

	}

}
