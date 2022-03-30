package main.dto.message;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class FailureDTO {
    private String errorMessage;
    private LocalDateTime localDateTime;
}
