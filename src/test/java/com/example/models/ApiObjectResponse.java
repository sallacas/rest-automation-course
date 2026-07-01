package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiObjectResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private String name;

    // Antes llamabamos el Map -> Llamar el objeto DTO (Clase)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ObjectData data;
}
