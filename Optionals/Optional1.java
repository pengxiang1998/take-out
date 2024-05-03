package Optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Optional1 {
    public static void main(String[] args)  {
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

    }
    public static Author getAuthor(){
        Author author=new Author("罗贯中",46);
        return author;
    }
    public static Optional<Author> getOptionAuthor(){
        Author author=new Author("罗贯中",46);
        return Optional.empty();
    }
}
