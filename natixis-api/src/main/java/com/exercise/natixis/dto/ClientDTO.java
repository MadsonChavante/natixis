package com.exercise.natixis.dto;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record ClientDTO(
    Long id,

    @NotEmpty(message = "Name cannot be empty")
    String name,

    LocalDate birthDate,

    @NotEmpty(message = "NIF cannot be empty")
    String nif,

    @Valid 
    @NotNull(message = "Address cannot be null")
    AddressDTO address
) {}
