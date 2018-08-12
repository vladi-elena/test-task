package ru.ekviron.service.order.application;

import org.springframework.stereotype.Service;
import ru.ekviron.service.order.application.exception.InvalidFieldException;
import ru.ekviron.service.order.application.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 * <p>
 * Сервис валидации полей объектов представления.
 */
@Service
public class ValidationService {

    private final Validator validator;

    /**
     * Конструктор по умолчанию, инициализирует Валидатор.
     */
    public ValidationService() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    /**
     * Проверяет валидность объекта, собирая  информацию о всех невалидных полях.
     * <p>
     *
     * @param obj проверяемый объект
     * @param <T> тип объекта
     * @throws ValidationException выбрасывается если проверяемый объект невалидный
     */
    public <T> void validate(final T obj) throws ValidationException {
        Set<ConstraintViolation<T>> errors = validator.validate(obj);
        if (!errors.isEmpty()) {
            ValidationException validationException = new ValidationException("Validation Failed");
            errors.forEach(e -> validationException.addError(new InvalidFieldException(
                    e.getPropertyPath().toString(), e.getMessage())));
            throw validationException;
        }
    }

}
