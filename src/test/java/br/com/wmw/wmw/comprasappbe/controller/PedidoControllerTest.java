package br.com.wmw.wmw.comprasappbe.controller;

import static org.junit.jupiter.api.Assertions.*;

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
public class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver200CasoMetodoPostFuncione() throws Exception {
        URI uri = new URI("/pedidos");

        String json = "{\"codigoPedido\":105,\"codigoCliente\":1,\"dataEmissao\":\"2022-10-21\",\"dataEntrega\":\"2022-12-25\""
        		+ ",\"totalPedido\":400.0,\"statusPedido\":\"FECHADO\",\"itens\":[{\"id\":74,\"idProduto\":3,\"quantidade\":2.0"
        		+ ",\"precoUnitario\":250.0,\"desconto\":20.0,\"totalItem\":400.0}]}";

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
