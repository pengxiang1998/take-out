package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();
        stream.map(author -> author.getAge())
                .reduce((result, element) -> result > element ? result : element);
        stream.map(author -> author.getAge())
                .reduce((result, element) -> result > element ? result : element);



    }
    public static  void reduceMax(){
        ArrayList<Author> authors = getAuthors();
        Integer reduce = authors.stream().map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer max, Integer element) {
                        return max > element ? max : element;
                    }
                });
        Integer reduce1 = authors.stream().map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (max, element) -> max > element ? max : element);
        System.out.println(reduce);
    }
    public static  void reduce1(){
        ArrayList<Author> authors = getAuthors();
        Integer reduce = authors.stream().distinct().map(new Function<Author, Integer>() {
            @Override
            public Integer apply(Author author) {
                return author.getAge();
            }
        }).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer result, Integer element) {
                return result + element;
            }
        });
        System.out.println(reduce);Integer reduce1 = authors.stream()
                .distinct().map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);
        System.out.println(reduce1);
    }
    public static void findFirst(){
        ArrayList<Author> authors = getAuthors();
        Optional<Author> first = authors.stream().sorted()
                .distinct()
                .findFirst();
        System.out.println(first);

    }

    public static void findAny(){
        ArrayList<Author> authors = getAuthors();
        Optional<Author> any = authors.stream()
                .filter(author -> author.getAge() > 16)
                .findAny();
        any.ifPresent(author -> System.out.println(author));
    }
    public static void allMatch(){
        ArrayList<Author> authors = getAuthors();
        boolean b = authors.stream().allMatch(author -> author.getAge() > 30);
        System.out.println(b);
    }
    public static void anyMatch(){
        ArrayList<Author> authors = getAuthors();
        boolean b = authors.stream().anyMatch(author -> author.getAge() > 80);
        System.out.println(b);
    }
    public static ArrayList<Author> getAuthors(){
        ArrayList<Author> list = new ArrayList<>();
        Author author1=new Author("罗贯中",46);
        Author author2=new Author("冰心",55);
        Author author3=new Author("鲁迅",67);


        ArrayList<Books> books1 = new ArrayList<>();
        ArrayList<Books> books2 = new ArrayList<>();
        ArrayList<Books> books3 = new ArrayList<>();

        Collections.addAll(books1,new Books("三国演义",45,"古典文学,历史"));
        Collections.addAll(books2,new Books("寄小读者",15,"现代文学,启蒙,教育"));
        Collections.addAll(books3,new Books("狂人日记",35,"近代文学"),new Books("阿Q正传",23,"近代文学,小说,教育"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        Collections.addAll(list,author1,author2,author3,author3);

        return list;

    }
}
