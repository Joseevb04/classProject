package es.dws.classProject.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import es.dws.classProject.domain.dtos.AddBookRequestDTO;
import es.dws.classProject.domain.dtos.BookDTO;
import es.dws.classProject.domain.entities.BookEntity;
import es.dws.classProject.domain.entities.GenreEntity;
import es.dws.classProject.enumerations.GenreEnum;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "genre", source = "genre", qualifiedByName = "mapGenreEntityToEnum")
    BookDTO toDTO(BookEntity bookEntity);

    @Named("mapGenreEntityToEnum")
    default GenreEnum mapGenreEntityToEnum(GenreEntity genreEntity) {
        return genreEntity != null ? genreEntity.getGenre() : null;
    }

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "genre", ignore = true)
    BookEntity toEntity(BookDTO bookDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "imageUrl", ignore = true),
            @Mapping(target = "genre", ignore = true)
    })
    BookEntity toEntity(AddBookRequestDTO bookDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "imageUrl", ignore = true),
            @Mapping(target = "genre", ignore = true)
    })
    void updateBookFromDTO(AddBookRequestDTO bookDTO, @MappingTarget BookEntity bookEntity);
}
