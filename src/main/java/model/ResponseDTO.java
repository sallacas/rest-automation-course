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

    public static ResponseDTO createBody() {
        return ResponseDTO.builder()
                .name("Producto 1")
                .data(ObjectData.builder()
                        .year(2023)
                        .price(99.99)
                        .cpuModel("Intel Core i7")
                        .hardDiskSize("1TB")
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
