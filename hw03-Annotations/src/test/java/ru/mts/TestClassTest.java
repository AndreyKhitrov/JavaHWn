package ru.mts;

//import org.junit.After;

import org.junit.AfterClass;
import org.junit.Assert;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestClassTest {

    private static int count_plus = 0;
    private static int count_minus = 0;
    private static int count_all = 0;
    private static final String nameTest = "";

    @BeforeClass
    @Before
    public static void setUp() throws Exception {
        System.out.println("Open testing");
        System.out.println("count_plus= "+Integer.toString(count_plus) +
                ";  count_minus= " + Integer.toString(count_minus) +
                ";  count_all= " + Integer.toString(count_all));
        //TestClass testConstr = new TestClass("Constr");

    }

    @AfterClass
    @After
    public static void tearDown() throws Exception {
        System.out.println("count_plus= "+Integer.toString(count_plus) +
                ";  count_minus= " + Integer.toString(count_minus) +
                ";  count_all= " + Integer.toString(count_all));
        System.out.println("End test");
    }

    @Test
    public void testToStringBefore() throws Exception {
        try {
            TestClass testBefore = new TestClass("Run before");
            Assert.assertTrue(testBefore.toStringBefore().contains("before"));
            count_plus++;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            count_minus++;
        }
        finally {
            count_all++;
            System.out.println("End testToStringBefore");
        }
    }

    @Test
    public void testToString() throws Exception {
        try {
            TestClass testTest = new TestClass("Run test");
            Assert.assertTrue(testTest.toString().contains("test"));
            count_plus++;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            count_minus++;
        }
        finally {
            count_all++;
            System.out.println("End testToString");
        }
    }

    @Test
    public void testToStringAfter() throws Exception {
        try {
            TestClass testAfter = new TestClass("Run after");
            Assert.assertTrue(testAfter.toStringAfter().contains("after"));
            count_plus++;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            count_minus++;
        }
        finally {
            count_all++;
            System.out.println("End testToStringAfter");
        }
    }
    @Test
    public void setValueTest() throws Exception {
        try {
            var testClass = new TestClass();
            testClass.setValue(nameTest);
            count_plus++;
        }
        catch (NullPointerException e)
        {
            System.out.println("Exception NullPointerException: " + e);
            count_minus++;
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
            count_minus++;
        }
        finally {
            System.out.println("End setValueTest");
            count_all++;
        }
    }
}