package com.exercise.natixis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.natixis.dto.ClientDTO;
import com.exercise.natixis.service.ClientService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;
    
    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO clientDTO) {
        service.save(clientDTO);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> read() {
        List<ClientDTO> clients = service.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

}

