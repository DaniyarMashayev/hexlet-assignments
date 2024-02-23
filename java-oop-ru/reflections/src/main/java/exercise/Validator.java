package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.ArrayList;

// BEGIN
public class Validator {
    public static void main(String[] args) {
        Address address1 = new Address("USA", "Houston", null, "3", null);
        System.out.println(advancedValidate(address1));
    }

    public static List<String> validate(Address address) {
        List<Field> fields = List.of(address.getClass().getDeclaredFields());
        return fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> {
                    Object value;
                    try {
                        field.setAccessible(true);
                        value = field.get(address);
                        field.setAccessible(false);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    return Objects.isNull(value);
                })
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        List<Field> fields = List.of(address.getClass().getDeclaredFields());
        fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class)
                        || field.isAnnotationPresent(MinLength.class))
                .forEach(field -> {
                    String fieldName = field.getName();
                    List<String> errors;
                    errors = getErrorMessage(address, field);
                    if (!errors.isEmpty()) {
                        result.put(fieldName, errors);
                    }
                });
        return result;
    }

    private static List<String> getErrorMessage (Address address, Field field) {
        List<String> errorMessage = new ArrayList<>();
        String valueField;
        field.setAccessible(true);
        try {
            valueField = (String) field.get(address);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        List<String> errorMessageWithNull = validate(address);

        if (errorMessageWithNull.contains(field.getName())) {
            errorMessage.add("can not be null");
        }

        if (field.isAnnotationPresent(MinLength.class)) {
            int value = field.getAnnotation(MinLength.class).minLength();
            if (valueField == null || valueField.length() < value) {
                errorMessage.add("length less than " + value);
            }
        }
        return errorMessage;
    }
}
