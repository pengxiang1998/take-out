package Optionals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Optional1 {
    public static void main(String[] args)  {
       map();

    }

    private static void map() {
        Author auhtor=getAuthor();
        Optional<Author> optionalAuthor = Optional.ofNullable(auhtor);
        optionalAuthor
                .map(author -> author.getBooks())
                .ifPresent(books -> System.out.println(books));
    }

    private static void filter() {
        Author auhtor=getAuthor();
        Optional<Author> optionalAuthor = Optional.ofNullable(auhtor);
        Optional<Author> author1 = optionalAuthor
                .filter(author -> author.getAge() > 140);

        optionalAuthor
                .filter(author -> author.getAge()>140)
                .ifPresent(author -> System.out.println(author));

    }

    public static void orElseGet(){
        Author auhtor=getAuthor();
        Optional<Author> optionalAuthor = Optional.ofNullable(auhtor);
        optionalAuthor.ifPresent(author -> System.out.println(author.getAge()));
        Optional<Author> optionAuthor = getOptionAuthor();
        //通过get方法获取存在空指针异常的风险
//        Author author1 = optionAuthor.get();
//        System.out.println(author1);
        Author author = optionAuthor.orElseGet(() -> new Author());
        try {
            Author author1 = optionAuthor
                    .orElseThrow((Supplier<Throwable>) () -> new RuntimeException("数据为null"));
            System.out.println(author1);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(author);
        System.out.println(1 / 4);
    }
    public static Author getAuthor(){
        ArrayList<Books> books=new ArrayList<>();
        Books book=new Books("三国演义",199);
        Collections.addAll(books,book);

        Author author=new Author("罗贯中",46,books);
        return author;
    }
    public static Optional<Author> getOptionAuthor(){
        Author author=new Author("罗贯中",46);
        return Optional.ofNullable(author);
    }
}
