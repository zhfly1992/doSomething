package Lambda;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaCC {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is old");
            }
        }).start();

        new Thread(() -> System.out.println("this is new")).start();

        List<String> test = Arrays.asList("java","scala","python");
        test.forEach(x -> System.out.println(x));

        List<String> collect = test.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        String s = test.stream().reduce((sum, x) -> sum + x).get();
        System.out.println(s);

        List<String> j = test.stream().filter(x -> x.startsWith("j")).collect(Collectors.toList());
        j.forEach(x -> System.out.println(x));

        System.out.println("--------------------------------");
        filterTest(test,x->x.startsWith("j"));
        filterTest(test,x->x.length() == 5);
    }

    public static void filterTest(List<String> languages,Predicate<String> predicate){
        languages.stream().filter(x-> predicate.test(x)).forEach(x -> System.out.println(x));
    }
}
