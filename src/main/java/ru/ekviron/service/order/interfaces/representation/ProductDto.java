package ru.ekviron.service.order.interfaces.representation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 * <p>
 * Модель представления продукта.
 */
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "View Model")
public class ProductDto {

    @ApiModelProperty(required = true)
    @NotEmpty(message = "The product name must not be empty")
    private String name;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "The product code must not be empty")
    @Size(min = 13, max = 13, message = "The product code must be a fixed-length string, 13 characters")
    private String code;

}
