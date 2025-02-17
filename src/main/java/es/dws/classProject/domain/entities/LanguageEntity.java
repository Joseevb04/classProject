package es.dws.classProject.domain.entities;

import es.dws.classProject.enumerations.LanguageEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "language")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageEntity {

    @Id
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

}
