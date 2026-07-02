package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private String name;

    // Antes llamabamos el Map -> Llamar el objeto DTO (Clase)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ObjectData data;
}
