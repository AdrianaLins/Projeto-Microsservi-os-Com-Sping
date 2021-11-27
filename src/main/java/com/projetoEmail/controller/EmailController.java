package com.projetoEmail.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoEmail.dto.EmailDto;
import com.projetoEmail.model.EmailModel;
import com.projetoEmail.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	//Envio de email
	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
		EmailModel emailModel = new EmailModel(); //precisa transformar o DTO em Model para que consiga salvar o email no banco de dados
		BeanUtils.copyProperties(emailDto, emailModel); //esse método vai fazer a conversão do email DTO para o Model
		emailService.sendEmail(emailModel);
		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
		
	}

}
