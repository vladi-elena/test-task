package ru.ekviron.service.order.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ekviron.service.order.application.exception.ValidationException;
import ru.ekviron.service.order.interfaces.representation.ErrorDto;
import ru.ekviron.service.order.interfaces.representation.ErrorResponseDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 */
@ControllerAdvice
public class CommonExceptionHandlers {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> validationExceptionHandler(final ValidationException exception) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto("400", exception.getMessage());
        List<ErrorDto> errors = exception.getErrors().stream()
                .map(e -> new ErrorDto(e.getField(), e.getMessage()))
                .collect(Collectors.toList());
        errorResponseDto.setErrors(errors);
        return ResponseEntity.badRequest().body(errorResponseDto);
    }
}
