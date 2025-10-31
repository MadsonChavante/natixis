package com.exercise.natixis.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;


public record ClientDTO(
    Long id,

    @NotEmpty(message = "Name cannot be empty")
    String name,

    LocalDate birthDate,

    @NotEmpty(message = "NIF cannot be empty")
    String nif
) {}
