package com.example.SpringBank;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Helpers {
    public static void checkClassHasField(Class checkedClass, String fieldName, Class intendedFieldClass) {
        try {
            Field field = checkedClass.getDeclaredField(fieldName);
            // Check if the field's type is the expected one
            assertEquals(intendedFieldClass, field.getType(), String.format("Field type should be %s.", intendedFieldClass));
        } catch (NoSuchFieldException e) {
            fail(String.format("Class '%s' does not have '%s' field.", checkedClass, fieldName));
        }
    }
    public static void checkClassIsAbstract(Class checkedClass) {
        try {
            assert(Modifier.isAbstract(checkedClass.getModifiers()));
        } catch (AssertionError e) {
            fail(String.format("Class '%s' is not abstract.", checkedClass));
        }
    }
}
