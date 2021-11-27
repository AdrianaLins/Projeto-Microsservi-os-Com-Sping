package com.projetoEmail.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.projetoEmail.enu.StatusEmail;
import com.projetoEmail.model.EmailModel;
import com.projetoEmail.repository.EmailRepository;

//Camada intermediária entre o repository e controller
@Service // é um bean do spring do tipo service
public class EmailService {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;
	
	//salvamento e envio de email
	public EmailModel sendEmail(EmailModel emailModel) {
		
		emailModel.setSendDateEmail(LocalDateTime.now());
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			//salva todos os dados para fazer o envio
			emailSender.send(message);
			
			//Se tudo der certo, salva o email com status email enviado
			emailModel.setStatusEmail(StatusEmail.SENT);
			
		} catch (MailException e) {
			//Caso contrário, dá erro
			emailModel.setStatusEmail(StatusEmail.ERROR);
			
		} finally {
			//Salva se deu tudo ok ou se deu erro salva no banco de dados
			return emailRepository.save(emailModel);
		}
		
		
	}

}
