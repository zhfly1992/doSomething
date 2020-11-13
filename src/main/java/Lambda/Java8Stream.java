package Lambda;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;


public class Java8Stream {
    public static void main(String[] args) {
      try{
          //存放apple对象集合
          List<Apple> appleList = new ArrayList<>();

          Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
          Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
          Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
          Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

          appleList.add(apple1);
          appleList.add(apple12);
          appleList.add(apple2);
          appleList.add(apple3);

          Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));


          System.out.println(groupBy);

          Map appleMap = (Map) appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1, k2)->k2));
          System.out.println(appleMap);

          List<Integer> aa = appleList.stream().map(Apple::getId).collect(Collectors.toList());
          System.out.println(aa);

          List<Apple> apples = appleList.stream().filter(x -> x.getId() == 1).collect(Collectors.toList());
          System.out.println(apples);


          System.out.println("--------------------------------------------------------");

          Stream<List<Integer>> inputStream = Stream.of(
                  Arrays.asList(1),
                  Arrays.asList(2, 3),
                  Arrays.asList(4, 5, 6)
          );
          Stream<Integer> outputStream = inputStream.
                  flatMap((childList) -> childList.stream().filter(c -> c >3).map(a -> a *2));

          System.out.println(outputStream.collect(Collectors.toList()));

//          inputStream.forEach(a -> System.out.println(a));

          Integer reduce = appleList.stream().map(a -> a.getNum()).reduce(Integer::sum).get();
          System.out.println(reduce);
          Integer min = appleList.stream().map(a -> a.getNum()).reduce(Integer.MAX_VALUE, Integer::min);
          System.out.println(min);
          List<Integer> collect = appleList.stream().map(a -> a.getId()).limit(3).skip(1).collect(Collectors.toList());
          System.out.println(collect);

          Integer max = appleList.stream().mapToInt(a ->a.getNum()).max().getAsInt();
          System.out.println(max);

          List<Integer> distinct = appleList.stream().map(a -> a.getId()).distinct().collect(Collectors.toList());
          System.out.println(distinct);

          boolean anyMatch = appleList.stream().anyMatch(a -> a.getId() == 1);
          System.out.println(anyMatch);

          Stream.generate(()->(int) (System.nanoTime() % 100)).limit(10).forEach(System.out::println);

      }
      catch (Exception e){
          e.printStackTrace();
      }
    }
}
