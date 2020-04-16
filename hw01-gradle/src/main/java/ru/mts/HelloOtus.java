package ru.mts;

import com.google.common.base.Splitter;
import java.util.List;

public class HelloOtus {

    public static void main(String[] args) {
        List<String> str = Splitter.on("+")
                .splitToList("This is first string+second string");

        System.out.println(new StringBuilder().append("Proverka:").append(str).toString());
    }
}