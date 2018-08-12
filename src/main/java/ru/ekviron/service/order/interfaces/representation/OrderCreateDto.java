package ru.ekviron.service.order.interfaces.representation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 * <p>
 * Модель представления создания заказа продуктов.
 */
@NoArgsConstructor
@Setter
@Getter
@ApiModel(description = "View Model")
public class OrderCreateDto {

    @ApiModelProperty(required = true)
    @NotEmpty(message = "The seller ID must not be empty")
    @Size(min = 9, max = 9, message = "The seller ID must be a fixed-length string, 9 characters")
    private String seller;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "The customer ID must not be empty")
    @Size(min = 9, max = 9, message = "The customer ID must be a fixed-length string, 9 characters")
    private String customer;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "The product list must not be empty")
    @Valid
    private List<ProductDto> products;

}
