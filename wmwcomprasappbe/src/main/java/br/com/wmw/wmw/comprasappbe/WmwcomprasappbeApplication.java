package br.com.wmw.wmw.comprasappbe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.wmw.wmw.comprasappbe.models.Produto;
import br.com.wmw.wmw.comprasappbe.repo.ProdutoRepository;
	
@SpringBootApplication
public class WmwcomprasappbeApplication implements CommandLineRunner  {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WmwcomprasappbeApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		List<Produto> produtos = produtoRepository.findAll();
		produtos.forEach(System.out :: println);
		
	}
	
	

}
