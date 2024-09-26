package br.com.assembler.api.assembler;

import br.com.assembler.api.model.PersonModel;
import br.com.assembler.domain.model.Person;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PersonAssembler {

    private final ModelMapper modelMapper;

    public PersonModel toModel(Person person) {
        return modelMapper.map(person, PersonModel.class);
    }

    public List<PersonModel> toListModel(List<Person> personList) {
        return personList.stream().map(this::toModel)
                .collect(Collectors.toList());
    }
}
