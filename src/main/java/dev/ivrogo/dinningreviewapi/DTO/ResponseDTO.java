package dev.ivrogo.dinningreviewapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {

    private String message;
    private T value;

}
