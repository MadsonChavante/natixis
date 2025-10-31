package com.exercise.natixis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.natixis.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByNif(String nif);

    List<Client> findAll();
    
}
