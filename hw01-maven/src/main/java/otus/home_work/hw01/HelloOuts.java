package otus.home_work.hw01;

import com.google.common.base.Joiner;

import java.util.ArrayList;

public class HelloOuts {
    public static void main(String[] args) {
        System.out.println("Test");
        Joiner joiner = Joiner.on("_").useForNull("Otus");
        System.out.printf(joiner.join("Test", "Home", "Work", "maven", null));
        ArrayList<Integer> list = new ArrayList<>();
    }
}