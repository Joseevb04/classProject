package es.dws.classProject.mappers;

import java.time.Year;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.domain.entities.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity toEntity(BookDTO bookDTO);

    BookDTO toDTO(BookEntity bookEntity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    void updateBookFromDTO(BookDTO bookDTO, @MappingTarget BookEntity bookEntity);

    default Year map(Integer value) {
        return value == null ? null : Year.of(value);
    }

    default Integer map(Year value) {
        return value == null ? null : value.getValue();
    }
}
