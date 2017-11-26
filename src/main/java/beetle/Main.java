package beetle;

import beetle.Entities.Product;
import beetle.Entities.ProductsInReseipt;
import beetle.Entities.Receipt;
import beetle.Entities.User;
import beetle.Services.MainServise;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
    String text = sdf.format(date);
    User user = new User("User 1","user1@gmail");
    User userTwo = new User("User 2","user2@gmail");
    User userThree = new User("User 3", "user3@gmail");
    Product product = new Product("Папуга Амазон",10000.5, "/resources/images/amazon1.jpg");
    Product productTwo = new Product("Папуга Амазон",15000.5, "/resources/images/amazon2.jpg");
    Product productThree = new Product("Папуга Какаду",8001.94, "/resources/images/kakadu1.jpg");
    Product productFour = new Product("Папуга Какаду",9000.0, "/resources/images/kakadu2.jpg");
    Product productFive = new Product("Папуга Корелла",4359.0, "/resources/images/korella1.jpg");
    Product productSix = new Product("Папуга Корелла",5000.0, "/resources/images/korella2.jpg");
    List<Product> products = new ArrayList<Product>();
    List<Product> productsTwo = new ArrayList<Product>();
    List<Product> productsThree = new ArrayList<Product>();

    @Bean
        public CommandLineRunner addProduct(final MainServise mainServise) {
            return new CommandLineRunner() {
                @Override
                public void run(String... strings) throws Exception {
                    mainServise.addProduct(product);
                    mainServise.addProduct(productThree);
                    mainServise.addProduct(productTwo);
                    mainServise.addProduct(productFour);
                    mainServise.addProduct(productFive);
                    mainServise.addProduct(productSix);
                }
            };
        }

    @Bean
    public CommandLineRunner addUser(final MainServise mainServise) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                mainServise.addUser(user);
                mainServise.addUser(userTwo);
                mainServise.addUser(userThree);
            }

        };

    }

    @Bean
    public CommandLineRunner addReceipt(final MainServise mainServise) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                products.add(productThree);
                products.add(product);
                products.add(productFive);
                productsTwo.add(productFive);
                productsTwo.add(productSix);
                productsThree.add(productTwo);
                productsThree.add(productFour);
                Receipt receipt = new Receipt(text,user,products);
                Receipt receipt1 = new Receipt(text,userTwo,productsTwo);
                Receipt receipt2 = new Receipt(text, userThree, productsThree);
                mainServise.addReceipt(receipt);
                mainServise.addReceipt(receipt1);
                mainServise.addReceipt(receipt2);
                for (Product product1 : products) {
                    ProductsInReseipt productsInReseipt = new ProductsInReseipt(receipt.getId(), product1.getId(),user.getName(),user.getEmail(),text);
                    mainServise.addProductsInReceipt(productsInReseipt);
                }
                for (Product product1 : productsTwo) {
                    ProductsInReseipt productsInReseipt = new ProductsInReseipt(receipt1.getId(), product1.getId(),userTwo.getName(),userTwo.getEmail(),text);
                    mainServise.addProductsInReceipt(productsInReseipt);
                }
                for (Product product1 : productsThree) {
                    ProductsInReseipt productsInReseipt = new ProductsInReseipt(receipt2.getId(), product1.getId(),userThree.getName(),userThree.getEmail(),text);
                    mainServise.addProductsInReceipt(productsInReseipt);
                }
            }
        };
    }
    }

