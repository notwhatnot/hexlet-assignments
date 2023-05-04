package exercise;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class Validator {

    public static List<String> validate(Object address) {
        List<Field> fields = Arrays.asList(address.getClass().getDeclaredFields());
        return fields.stream()
                .peek(field -> field.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> getFieldValue(field, address) == null)
                .map(Field::getName)
                .toList();
    }

    public static Map<String, List<String>> advancedValidate(Object address) {
        final String nullErrorMessage = "can not be null";
        final String minLengthErrorMessage = "length less than ";

        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            List<String> errorMessages = new ArrayList<>();

            if (field.isAnnotationPresent(NotNull.class) && getFieldValue(field, address) == null) {
                errorMessages.add(nullErrorMessage);
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                int minLengthAnnotationLength = minLengthAnnotation.minLength();
                if (getFieldValue(field, address).toString().length() < minLengthAnnotationLength) {
                    errorMessages.add(minLengthErrorMessage + minLengthAnnotationLength);
                }
            }

            result.put(field.getName(), errorMessages);

        }

         return result.entrySet().stream()
                .filter(e -> !e.getValue().isEmpty())
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }


    private static Object getFieldValue(Field field, Object target) {
        try {
            return field.get(target);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
