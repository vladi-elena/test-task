package ru.ekviron.service.order.interfaces.representation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 * <p>
 * Объект документа отправляемого в составе ответа в случае возникновения ошибки.
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel(description = "View Model")
@JsonPropertyOrder({"code", "message", "timestamp", "errors"})
public class ErrorResponseDto {

    @ApiModelProperty(required = true)
    private String code;

    @ApiModelProperty(required = true)
    private String message;

    @ApiModelProperty(required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "UTC")
    private Instant timestamp;

    @ApiModelProperty(required = true)
    private List<ErrorDto> errors;

    public ErrorResponseDto(final String code, final String message) {
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now();
    }
}
