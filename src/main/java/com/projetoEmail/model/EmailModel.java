package com.projetoEmail.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projetoEmail.enu.StatusEmail;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID emailId; //para evitar conflitos dentro da arquitetura
	private String ownerRef; //qual usuário esta recebendo o email
	private String emailFrom; //quem esta enviando o email
	private String emailTo; //email que esta sendo enviado
	private String subject; //titulo do email
	@Column(columnDefinition = "TEXT")
	private String text; //corpo do email
	private LocalDateTime sendDateEmail; //data que esta sendo enviada
	private StatusEmail statusEmail; //status do email
	
	public EmailModel() {
		
	}
	
	public EmailModel(UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text,
			LocalDateTime sendDateEmail, StatusEmail statusEmail) {
		super();
		this.emailId = emailId;
		this.ownerRef = ownerRef;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.subject = subject;
		this.text = text;
		this.sendDateEmail = sendDateEmail;
		this.statusEmail = statusEmail;
	}

	public UUID getEmailId() {
		return emailId;
	}

	public void setEmailId(UUID emailId) {
		this.emailId = emailId;
	}

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getSendDateEmail() {
		return sendDateEmail;
	}

	public void setSendDateEmail(LocalDateTime sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}

	public StatusEmail getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
