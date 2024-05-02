package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Author> list = new ArrayList<>();
        list.add(new Author("李白",46));
        list.add(new Author("杜甫",55));
        list.add(new Author("白居易",67));
        list.add(new Author("白居易",67));
        list.stream().distinct().sorted().forEach(author -> System.out.println(author));
        list.stream().distinct().sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .forEach(author -> System.out.println(author));
        System.out.println("作家去除重复的，并按照年龄排序后，只输出前2个元素");
        list.stream().distinct().sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author));
        System.out.println("作家去除重复的，并按照年龄排序后，并排除年龄最大的元素");
        list.stream().distinct().sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author));
    }
}
