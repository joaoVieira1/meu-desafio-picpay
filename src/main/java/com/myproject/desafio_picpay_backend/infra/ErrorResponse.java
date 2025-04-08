package com.myproject.desafio_picpay_backend.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String message;

}
