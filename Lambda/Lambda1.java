package Lambda;

import java.util.function.Function;

public class Lambda1 {
    public static void main(String[] args) {
        //使用匿名内部类，直接重写接口中的方法，省去创建实现类实现接口的过程和创建实现类对象的过程。
        Integer i = TypeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
        System.out.println(i);
        //Lambda表达式实现字符串拼接
        Integer m = TypeConver((String s) ->{return Integer.valueOf(s);});
        System.out.println(m);
        String string = TypeConver((String str) -> {
            return str + "你好";
        });
        System.out.println(string);
    }
//    Function<T, R> 是 Java 8 中的一个函数式接口，
//    用于表示接受一个输入参数 T，并返回一个结果 R 的函数。
//    Function接口中有一个抽象方法apply，用于定义函数的逻辑。
//    Function接口通常用于将数据进行转换、映射或者执行某种转换操作。
    public static <R> R TypeConver(Function<String,R> function){
        String str="12345";
        R result=function.apply(str);
        return result;
    }
}
