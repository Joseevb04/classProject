package es.dws.classProject.mappers;

import java.time.Year;

import org.mapstruct.Mapper;

import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.domain.entities.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity toEntity(BookDTO bookDTO);

    BookDTO toDTO(BookEntity bookEntity);

    default Year map(Integer value) {
        return value == null ? null : Year.of(value);
    }

    default Integer map(Year value) {
        return value == null ? null : value.getValue();
    }
}
