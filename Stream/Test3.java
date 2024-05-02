package Stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<Author> authors = getAuthors();
        List<String> collect = authors.stream().map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());//我们不调用对象去写匿名方法，而是直接调用Collectors这个工具类
        System.out.println(collect);

        Set<String> collect1 = authors.stream().map(author -> author.getName())
                .distinct().collect(Collectors.toSet());
        System.out.println(collect1);

        Map<String, List<Books>> collect2 = authors.stream().distinct()
                .collect(Collectors.toMap( author -> author.getName(), author -> {
                    return author.getBooks();
                }));
        System.out.println(collect2);

    }
    public static void max_min(){
        ArrayList<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .map(books -> books.getPrice())
                .max((o1, o2) -> o1 - o2);
        System.out.println(max.get());
    }
    public static void count(){
        ArrayList<Author> authors = getAuthors();
        authors.stream()
                .flatMap( author -> author.getBooks().stream())
                .distinct()
                .forEach(books -> System.out.println(books));
        long count = authors.stream()
                .flatMap( author -> author.getBooks().stream())
                .distinct().count();
        System.out.println(count);
    }
    public static void flatmap2(){
        List<Author> authors=getAuthors();
        authors.stream().distinct().flatMap(new Function<Author, Stream<Books>>() {
            @Override
            public Stream<Books> apply(Author author) {
                return author.getBooks().stream();
            }
        }).distinct().flatMap(new Function<Books, Stream<String>>() {
            @Override
            public Stream<String> apply(Books books) {
                return Arrays.stream(books.getCategory().split(","));
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        authors.stream().distinct()
                .flatMap( author -> author.getBooks().stream())
                .distinct()
                .flatMap( books -> Arrays.stream(books.getCategory().split(",")))
                .forEach((Consumer<String>) s -> System.out.println(s));
    }
    public static void faltmap(){
        List<Author> authors=getAuthors();
        authors.stream().distinct().map(new Function<Author,List<Books>>() {
            @Override
            public List<Books> apply(Author author) {
                return author.getBooks();
            }
        }).forEach(new Consumer<List<Books>>() {
            @Override
            public void accept(List<Books> books) {
                System.out.println(books);
            }
        });
        authors.stream().distinct()
                .map(author -> author.getBooks())
                .forEach(books -> System.out.println(books));
        authors.stream().distinct().flatMap(new Function<Author, Stream<Books>>() {
            @Override
            public Stream<Books> apply(Author author) {
                return author.getBooks().stream();
            }
        }).forEach(new Consumer<Books>() {
            @Override
            public void accept(Books books) {
                System.out.println(books);
            }
        });
        authors.stream().distinct()
                .flatMap(author -> author.getBooks().stream())
                .forEach( books -> System.out.println(books));
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
