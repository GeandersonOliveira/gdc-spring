package com.gdc;

import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@Configuration
public class RabbitMQcfg {
	
	@Bean
	public Queue queueCriacao() {
		return new Queue ("queue.v1.cadastro-criado");
	}
	
	@Bean
	public RabbitAdmin rabbitAdmin (ConnectionFactory connectionFactory) {  //cfg para criar a fila na inicialização
		return new RabbitAdmin(connectionFactory);
	}

	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener 
			(RabbitAdmin rabbitAdmin){		
		return event -> rabbitAdmin.initialize();
						
		}	
	
	@Bean
    public Jackson2JsonMessageConverter messageConverter() { //Serializar mensagem (objeto) em JSON no rabbitMQ
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

}


	

