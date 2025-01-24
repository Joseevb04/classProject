package es.dws.classProject.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import es.dws.classProject.domain.dtos.AddBookRequestDTO;
import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.domain.entities.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "createdAt", ignore = true)
    BookEntity toEntity(BookDTO bookDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    BookEntity toEntity(AddBookRequestDTO bookDTO);

    @Mapping(target = "createdAt", ignore = true)
    BookDTO toDTO(BookEntity bookEntity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    void updateBookFromDTO(AddBookRequestDTO bookDTO, @MappingTarget BookEntity bookEntity);

}
