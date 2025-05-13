package com.example.SpringBank.common;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Imports for tests
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Helpers {
    /**
     * Check if a class is an abstract class.
     * @param checkedClass The class to check whether it is abstract
     */
    public static void checkClassIsAbstract(Class<?> checkedClass) {
        try {
            assert(Modifier.isAbstract(checkedClass.getModifiers()));
        } catch (AssertionError e) {
            fail(String.format("Class '%s' is not abstract.", checkedClass));
        }
    }

    /**
     * Check if a class has the field of the specified class.
     * @param checkedClass The class to check if containing the specified field
     * @param fieldName The name of the field <code>checkedChass</code> should contain
     * @param intendedFieldClass The type/class that <code>checkedChass.fieldName</code> should be
     */
    public static void checkClassHasField(Class<?> checkedClass, String fieldName, Class<?> intendedFieldClass) {
        try {
            Field field = checkedClass.getDeclaredField(fieldName);
            // Check if the field's type is the expected one
            assertEquals(intendedFieldClass, field.getType(), String.format("Field type should be %s.", intendedFieldClass));
        } catch (NoSuchFieldException e) {
            fail(String.format("Class '%s' does not have '%s' field.", checkedClass, fieldName));
        }
    }

    /**
     * Check if a class has a specific enum with the specified values.
     *
     * @param checkedClass The class to check if containing the specified enum
     * @param enumName     The name of the enum <code>checkedChass</code> should contain
     * @param values       A list of values the enum should contain
     */
    public static void checkClassHasEnum(Class<?> checkedClass, String enumName, String[] values) {
        Class<?>[] classes = checkedClass.getDeclaredClasses();

        // Loop through each declared class and check if it is an enum
        for (Class<?> declaredClass : classes) {
            // Check if the class is an enum of `enumName`
            if (declaredClass.isEnum() && !Modifier.isAbstract(declaredClass.getModifiers()) && declaredClass.getName().endsWith(enumName)) {
                // Build a set for all the values in enum
                Field[] fields = declaredClass.getFields();
                Set<String> valuesInEnum = new HashSet<String>(Set.of());
                for (Field field: fields) {
                    valuesInEnum.add(field.getName());
                }
                // Check if the enum has specified values
                for (String value: values) {
                    if (!valuesInEnum.contains(value)) {
                        fail(String.format("Class '%s' has enum '%s', but the enum does not contain value '%s'.", checkedClass, enumName, value));
                    }
                }
                return;
            }
        }
        fail(String.format("Class '%s' does not have enum '%s'.", checkedClass, enumName));
    }

    /**
     * Check if the field of the <code>checkedClass</code> has a specific annotation.
     * @param checkedClass The class containing the to be checked
     * @param fieldName The name of the field to check
     * @param annotation The annotation <code>checkedChass.fieldName</code> should contain
     */
    public static void checkFieldHasAnnotation(Class<?> checkedClass, String fieldName, Class<? extends Annotation> annotation) throws NoSuchFieldException {
        // Get the field from the class by field name
        Field field = checkedClass.getDeclaredField(fieldName);

        // Get all annotations present on the field
        Annotation[] fieldAnnotations = field.getAnnotations();
        boolean hasAnnotation = false;

        // Check if the field has the same annotation as the passed-in 'annotation' parameter
        for (Annotation fieldAnnotation : fieldAnnotations) {
            if (fieldAnnotation.annotationType().equals(annotation)) {
                hasAnnotation = true;
                System.out.println("The field '" + fieldName + "' has the annotation: " + annotation.getName());
                break;  // Annotation found, no need to continue
            }
        }

        // Assert if annotation is not found
        if (!hasAnnotation) {
            throw new AssertionError("The field '" + fieldName + "' does not have the annotation: " + annotation.getName());
        }
    }
}
