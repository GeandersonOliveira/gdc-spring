package com.gdc;



import java.util.List;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gdc.PedidoRepository;
import com.gdc.dtoCadastro;
	
	@EnableCaching
	@RestController
	@RequestMapping
	@Cacheable("/listar") //redis

	public class PedidoController {
	int i = 1;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping ("/listar")
	public List<Pedido> listar() {	 //buscar no banco de dados	
		
		System.out.println("Sem Cache");
		i = i++;
		
		
		return pedidoRepository.findAll();					
	}
	@GetMapping("/limpar")
	@CacheEvict("/listar")
	public String limparCache() {
		System.out.println("Limpando o Cache Redis....");
		return "Cache Limpo";
	}
	
	
	
	@PostMapping("/pedido")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido gravar(@RequestBody Pedido pedido) {	//salvar no banco de dados	
		pedidoRepository.save(pedido);
		
	String queueName = "queue.v1.cadastro-criado"; //rabbitMQ
	dtoCadastro dtocadastro = new dtoCadastro (pedido.getId(), pedido.getName());
	
	rabbitTemplate.convertAndSend(queueName, dtocadastro);
	return pedido;
		
	}

}