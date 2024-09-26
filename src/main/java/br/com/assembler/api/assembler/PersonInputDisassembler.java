package br.com.assembler.api.assembler;

import br.com.assembler.api.model.PersonInput;
import br.com.assembler.domain.model.Person;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonInputDisassembler {

    private final ModelMapper modelMapper;

    public Person toDomainObject(PersonInput personInput) {
        return modelMapper.map(personInput, Person.class);
    }
}
