package es.dws.classProject.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO {

    private Long userId;
    private Long bookId;
    private Integer rating;
    private String comment;

}
