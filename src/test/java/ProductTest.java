import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void saveTest() {
        RepositoryProduct repo = new RepositoryProduct();
        Book book = new Book();
        Smartphone smartphone = new Smartphone();
        repo.save(book);
        repo.save(smartphone);

        Product[] expected = {book, smartphone};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteTest() {
        RepositoryProduct repo = new RepositoryProduct();
        Book book = new Book();
        Smartphone smartphone = new Smartphone();
        book.setId(5);
        smartphone.setId(45);
        repo.save(smartphone);
        repo.save(book);
        repo.delete(book.getId());

        Product[] expected = {smartphone};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoTest() {
        RepositoryProduct repo = new RepositoryProduct();
        Book book = new Book();
        Smartphone smartphone = new Smartphone();
        repo.save(book);
        repo.save(smartphone);
        ProductManager productManager = new ProductManager(repo);


        Product[] expected = {book, smartphone};
        Product[] actual = productManager.getRepositoryProduct().getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addTest() {
        RepositoryProduct repo = new RepositoryProduct();
        Book book = new Book();
        Smartphone smartphone = new Smartphone();
        repo.save(book);
        repo.save(smartphone);
        ProductManager productManager = new ProductManager(repo);
        productManager.add(book);

        Product[] expected = {book, smartphone, book};
        Product[] actual = productManager.getRepositoryProduct().getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTest() {
        RepositoryProduct repo = new RepositoryProduct();
        Book book = new Book("Пушкин");
        Smartphone smartphone = new Smartphone("Xiaomi");
        repo.save(book);
        repo.save(smartphone);
        ProductManager productManager = new ProductManager(repo);
        productManager.searchBy("Пушкин");

        Product[] expected = {book};
        Product[] actual = productManager.searchBy("Пушкин");

        Assertions.assertArrayEquals(expected, actual);
    }
}