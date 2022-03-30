package main.dto.message;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class SuccessDTO {
    private String message;
    private String status;
    private LocalDateTime localDateTime;
}
