package com.projetoEmail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoEmail.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
