package br.com.wmw.wmw.comprasappbe.test;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PedidoAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver200CasoMetodoPostFuncione() throws Exception {
        URI uri = new URI("/pedidos");

        String json = "{\"codigoPedido\":43,\"codigoCliente\":1,\"dataEmissao\":\"2022-10-12\",\"dataEntrega\":\""
        		+ "2023-01-01\",\"totalPedido\":9700.0,\"statusPedido\":\"FECHADO\",\"itens\":[{\"id\":49,\"idProduto\":2,\""
        		+ "quantidade\":2.0,\"precoUnitario\":4850.0,\"desconto\":0.0,\"totalItem\":9700.0}]}";

        mockMvc
                		.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                		.andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));

    }


    @Test
    public void deveriaDevolver200CasoMetodoUpdateFuncione() throws Exception {
        URI uri = new URI("/pedidos/");

        String json = "{\"codigoPedido\":41,\"codigoCliente\":1,\"dataEmissao\":\"2022-10-12\",\"dataEntrega\":\"2022-10-13\""
        		+ ",\"totalPedido\":300.0,\"statusPedido\":\"FECHADO\",\"itens\":[{\"id\":47,\"idProduto\":1,\"quantidade\":2.0,\""
        		+ "precoUnitario\":150.0,\"desconto\":0.0,\"totalItem\":300.0}]}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));


    }

    @Test
    public void deveriaDevolver200CasoMetodoDeleteFuncione() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/pedidos/43")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));

    }


}
