package es.dws.classProject.config;

import es.dws.classProject.domain.entities.LanguageEntity;
import es.dws.classProject.enumerations.LanguageEnum;
import es.dws.classProject.repositories.LanguageRepository;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LanguageDataInitializer implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    @Override
    public void run(String... args) throws Exception {
        if (languageRepository.count() < LanguageEnum.values().length) {
            Stream.of(LanguageEnum.values())
                    .filter(l -> !languageRepository.existsById(l))
                    .map(l -> LanguageEntity.builder().language(l).build())
                    .forEach(languageRepository::save);
        }
    }
}
