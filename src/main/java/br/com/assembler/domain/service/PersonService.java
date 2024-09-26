package br.com.assembler.domain.service;

import br.com.assembler.domain.model.Person;
import br.com.assembler.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public void create(Person person) {
        personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

}
