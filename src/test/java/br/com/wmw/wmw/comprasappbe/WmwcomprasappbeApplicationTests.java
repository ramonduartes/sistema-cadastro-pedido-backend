package br.com.wmw.wmw.comprasappbe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import br.com.wmw.wmw.comprasappbe.apitest.PedidoAPITest;

@SpringBootTest(classes = PedidoAPITest.class)
@Profile("test")
class WmwcomprasappbeApplicationTests {

	@Test
	void contextLoads() {
	}

}
