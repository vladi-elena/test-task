package ru.ekviron.service.order.interfaces.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ekviron.service.order.application.OrderService;
import ru.ekviron.service.order.application.exception.ValidationException;
import ru.ekviron.service.order.interfaces.representation.OrderCreateDto;

import javax.inject.Inject;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 * <p>
 * Rest Controller для обработки заказов продуктов пользователя.
 */
@RestController
@RequestMapping
@Api(value = "Order Controller", tags = "Product Ordering", description = "Managing orders.")
public class OrderController {

    private OrderService orderService;

    /**
     * Открытый конструктор.
     * <p>
     *
     * @param orderService сервис заказов
     */
    @Inject
    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * POST Метод создания заказа.
     * <p>
     *
     * @param orderCreateDto объект представления
     * @throws ValidationException выбрасывается в случае если поля объекта представления некорректны.
     */
    @ApiOperation(value = "Method that allows clients to create Order.")
    @PostMapping(value = "/orders", produces = "application/json", consumes = "application/json")
    public ResponseEntity createOrder(@RequestBody final OrderCreateDto orderCreateDto) throws ValidationException {
        orderService.createOrder(orderCreateDto);
        return ResponseEntity.ok().build();
    }
}
