package ru.mts;

public class TestClass {

    private String value = "initValue";

    public TestClass() {
    }

    public TestClass(String value) throws Exception{
             this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value.equals("")){
            throw new NullPointerException();
        }
        this.value = value;
    }

    @Before
    public String toStringBefore() {
        return "toStringBefore{ @Before" +
            ", value='" + value + '\'' +
            '}';
    }

    @Override
    @Test
    public String toString() {
        return "toString{ @Test" +
                ", value='" + value + '\'' +
                '}';
    }
    @After
    public String toStringAfter() {
        return "toStringAfter{ @After" + ", value='" + value + '\'' + '}';
    }
}
