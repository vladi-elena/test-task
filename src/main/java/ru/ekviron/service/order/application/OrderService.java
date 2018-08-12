package ru.ekviron.service.order.application;

import org.springframework.stereotype.Service;
import ru.ekviron.service.order.application.exception.ValidationException;
import ru.ekviron.service.order.interfaces.representation.OrderCreateDto;

import javax.inject.Inject;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 * <p>
 * Сервис управления заказами  пользователя.
 */
@Service
public class OrderService {

    private ValidationService validationService;

    /**
     * Открытый конструктор.
     * <p>
     *
     * @param validationService сервис валидации
     */
    @Inject
    public OrderService(final ValidationService validationService) {
        this.validationService = validationService;
    }

    /**
     * Создает заказ.
     * <p>
     *
     * @param orderCreateDto объект представления
     * @throws ValidationException выбрасывается в случае если поля объекта представления некорректны.
     */
    public void createOrder(final OrderCreateDto orderCreateDto) throws ValidationException {
        validationService.validate(orderCreateDto);
        /* TODO Конвертируем объекты представления в объекты доменной модели, подсчитываем сумму заказа и сохраняем в базе данных. */
    }
}
