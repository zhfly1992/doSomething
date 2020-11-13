package Lambda;

import java.util.function.Predicate;

public class PredicateTest {

    /**违反了1.8的新特性—>函数式编程即:我们需要做到的是将函数作为参数,“说白了就是写更少的代码做更多的事” *
     * 比如换一个判断，需要更改test内的判断或者新增一个新的predicate*/
    Predicate<String> predicateS = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.equals("aaa");
        }
    };
    /** java8的写法  */
    public boolean predicateJava8(String s,Predicate<String> predicate){
        return predicate.test(s);
    }



    public static void main(String[] args) {
        String a = "aaa";
        PredicateTest predicateTest = new PredicateTest();
        System.out.println(predicateTest.predicateS.test("aaa"));
        System.out.println(predicateTest.predicateS.test("bbb"));
        System.out.println("------------");
        System.out.println(  predicateTest.predicateJava8("aaa",s -> s.equals("aaa")));
        System.out.println(  predicateTest.predicateJava8("bbb",s -> s.equals("aaa")));


    }

}
