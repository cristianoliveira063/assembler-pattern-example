package br.com.assembler.api.controller;

import br.com.assembler.api.assembler.PersonAssembler;
import br.com.assembler.api.assembler.PersonInputDisassembler;
import br.com.assembler.api.model.PersonInput;
import br.com.assembler.api.model.PersonModel;
import br.com.assembler.domain.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonAssembler personAssembler;
    private final PersonInputDisassembler personInputDisassembler;

    @GetMapping
    public List<PersonModel> searchAll() {
        return personAssembler.toListModel(personService.findAll());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody PersonInput personInput) {
        personService.create(personInputDisassembler.toDomainObject(personInput));

    }

}
