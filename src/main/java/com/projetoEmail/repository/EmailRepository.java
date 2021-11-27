package com.projetoEmail.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoEmail.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
