package br.com.assembler.config;

import br.com.assembler.api.model.PersonModel;
import br.com.assembler.domain.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        configureMapper(modelMapper);
        return modelMapper;
    }

    private void configureMapper(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Person.class, PersonModel.class)
                .addMappings(mapper -> mapper.map(src -> {
                    if (src.getCreatedAt() != null) {
                        return src.getCreatedAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                    }
                    return null;
                }, PersonModel::setFormattedCreatedAt));
    }

}
