package br.com.assembler.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonModel {

    private String name;
    private String email;
    private String formattedCreatedAt;
}
