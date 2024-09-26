package br.com.assembler.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInput {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;

}
