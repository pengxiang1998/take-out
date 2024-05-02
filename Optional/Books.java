package Optional;

public class Books {
    private String bookName;
    private Integer price;

    private String category;

    public Integer getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Books(String bookName, Integer price) {
        this.bookName = bookName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    public Books(String bookName, Integer price, String category) {
        this.bookName = bookName;
        this.price = price;
        this.category = category;
    }
}
