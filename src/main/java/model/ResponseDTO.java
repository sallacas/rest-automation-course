package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;
import java.util.Objects;

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

    public static ResponseDTO build(Map<String, String> datos) {
        return ResponseDTO.builder()
                .name(datos.get("name"))
                .data(ObjectData.builder()
                        .year(Objects.isNull(datos.get("year")) ? null : Integer.parseInt(datos.get("year")))
                        .price(Objects.isNull(datos.get("price")) ? null : Double.parseDouble(datos.get("price")))
                        .cpuModel(datos.get("cpuModel"))
                        .hardDiskSize(datos.get("hardDisk"))
                        .build())
                .build();
    }
}
