package com.exercise.natixis.dto;

import jakarta.validation.constraints.NotEmpty;

public record AddressDTO(
    @NotEmpty(message = "Address street cannot be empty")
    String street,

    @NotEmpty(message = "Address number cannot be empty")
    String number,

    String complement,

    @NotEmpty(message = "Address postalCode cannot be empty")
    String postalCode,

    @NotEmpty(message = "Address city cannot be empty")
    String city,

    @NotEmpty(message = "Address district cannot be empty")
    String district
) {}
