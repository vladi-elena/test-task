package ru.ekviron.service.order.interfaces.representation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 * <p>
 * Объект представления ошибки.
 * Поле field заполняется только в случае если ошибка связана с проверкой корректности полей объекта.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "View Model")
public class ErrorDto {

    @ApiModelProperty()
    private String field;

    @ApiModelProperty(required = true)
    private String message;

}
