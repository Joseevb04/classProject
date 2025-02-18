package es.dws.classProject.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.dws.classProject.domain.dtos.RatingDTO;
import es.dws.classProject.domain.entities.RatingEntity;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "username", source = "user.username")
    RatingDTO toDTO(RatingEntity ratingEntity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "key", ignore = true)
    RatingEntity toEntity(RatingDTO ratingDTO);

}
