package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

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

    public static ResponseDTO createBody(Map<String, String> datos) {
        return ResponseDTO.builder()
                .name(datos.get("name"))
                .data(ObjectData.builder()
                        .year(Integer.parseInt(datos.get("year")))
                        .price(Double.parseDouble(datos.get("price")))
                        .cpuModel(datos.get("cpuModel"))
                        .hardDiskSize(datos.get("hardDisk"))
                        .build())
                .build();
    }

    public static ResponseDTO partialBody() {
        return ResponseDTO.builder()
                .name("Zenbook 15")
                .data(ObjectData.builder()
                        .year(2025)
                        .build())
                .build();
    }

    public static ResponseDTO putBody() {
        return ResponseDTO.builder()
                .name("Samsung Galaxy S22")
                .data(ObjectData.builder()
                        .year(2023)
                        .price(799.99)
                        .cpuModel("Snapdragon 8 Gen 1")
                        .hardDiskSize("1TB")
                        .build())
                .build();
    }
}
