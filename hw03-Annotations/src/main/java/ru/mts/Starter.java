package ru.mts;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Starter {
    public static void main(String[] args) throws Exception {
        try {
            Class<TestClass> clazz = TestClass.class;
            Method method = clazz.getMethod("toString");
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println("This is " + Arrays.toString(annotations));
            Method before = clazz.getMethod("toStringBefore");
            Annotation[] beforeAnn = before.getDeclaredAnnotations();
            System.out.println("This is " + Arrays.toString(beforeAnn));
            Method after = clazz.getMethod("toStringAfter");
            Annotation[] afterAnn = after.getDeclaredAnnotations();
            System.out.println("This is " + Arrays.toString(afterAnn));

            TestClass testClass = new TestClass("Run TestClass");

            System.out.println(testClass.toStringBefore());
            System.out.println(testClass.toString());
            System.out.println(testClass.toStringAfter());

            String name="";
            TestClass testExc = new TestClass();
            testExc.setValue(name);
        }
        catch (NullPointerException e)
        {
            System.out.println("Exception NullPointerException: " + e);
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
        finally {
            System.out.println("End");
        }

        //TestClass testClass1 = new TestClass("");

    }
}
