package AnnotationSt;

import AnnotationSt.Length;
import AnnotationSt.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class testAnot {


    public static String validate(Object object) throws IllegalAccessException {

        ClassTarget classTarget = object.getClass().getAnnotation(ClassTarget.class);
        System.out.println("类的url" + classTarget.url());

        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method method:declaredMethods){
            if (method.isAnnotationPresent(ClassTarget.class)){
                ClassTarget annotation = method.getAnnotation(ClassTarget.class);
                System.out.println("student " + annotation.method());
            }
        }
        //通过反射获取object对象的类有哪些属性
        Field[] fields = object.getClass().getDeclaredFields();
        //for循环逐个遍历属性，看哪个字段上标了注解
        for (Field field:fields){
            // if判断：检查该字段上有没有标注了@Length注解
            if (field.isAnnotationPresent(Length.class)){
                //通过反射获取到该字段上标注的@Length注解的详细信息
                Length length = field.getAnnotation(Length.class);
                //由于mobile是私有字段，需要该语句才能在反射时访问私有变量
                field.setAccessible(true);
                // 用过反射获取字段的实际值的长度
                int value = ((String)field.get(object)).length();
                if (value < length.min() || value > length.max()){
                    return length.errorMsg();
                }

            }
        }
        return  "ok";
    }

    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student();
        student.setId(12312);
        student.setName("asd");
        student.setMobile("123");
        System.out.println(validate(student));
    }
}
