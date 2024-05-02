package Stream;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Author> list = new ArrayList<>();
        list.add(new Author("李白",46));
        list.add(new Author("杜甫",55));
        list.add(new Author("白居易",67));
        list.add(new Author("白居易",67));
        list.stream().forEach(s->System.out.println(s));
        list.stream()
                .filter(author -> author.getAge()>50)
                .forEach(author -> System.out.println(author));
        list.stream()
                .filter(author -> author.getAge()>50)
                .map(author -> author.getName())
                .forEach(s -> System.out.println(s));
        list.stream().distinct().forEach(author -> System.out.println(author));
    }
}
