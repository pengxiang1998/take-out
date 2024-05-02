package Stream;

import java.util.ArrayList;
import java.util.Objects;

public class Author implements Comparable<Author>{
    private String name;
    private Integer age;

    private ArrayList<Books> books;

    public Author(String name, Integer age, ArrayList<Books> books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
    }

    public ArrayList<Books> getBooks() {
        return books;
    }

    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(age, author.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Author o) {
        return this.getAge()-o.getAge();
    }
}
