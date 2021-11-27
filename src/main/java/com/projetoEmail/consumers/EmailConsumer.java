package com.projetoEmail.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.projetoEmail.dto.EmailDto;
import com.projetoEmail.model.EmailModel;
import com.projetoEmail.service.EmailService;

//classe que vai estar escutando a fila
@Component
public class EmailConsumer {

	//ponto de injeção
	@Autowired
	EmailService emailService;
	
	//método ouvinte que vai escutar a fila que foi definida
	@RabbitListener(queues = "${spring.rabbitmq.queue}") //usa essa anotação para mostrar a esse método que ele será um ouvinte e entrará em "ação"
	public void listen(@Payload EmailDto emailDto) {
		
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel); //converter emailDto em emailModel
		emailService.sendEmail(emailModel);
		System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
	}

}
