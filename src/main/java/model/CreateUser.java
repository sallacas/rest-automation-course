package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUser {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    private String email;
    private String password;

    public static CreateUser build(Map<String, String> datos) {
        return CreateUser.builder()
                .name(datos.get("name"))
                .email(datos.get("email"))
                .password(datos.get("password"))
                .build();
    }
    public static CreateUser buildLogin(String email, String password) {
        return CreateUser.builder()
                .email(email)
                .password(password)
                .build();
    }
}
