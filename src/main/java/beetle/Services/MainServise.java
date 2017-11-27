package beetle.Services;

import beetle.Entities.ProductsInReseipt;
import beetle.Entities.Receipt;
import beetle.Repositories.ProductsInReceiptsRepository;
import beetle.Repositories.ReceiptRepository;
import beetle.Entities.Product;
import beetle.Entities.User;
import beetle.Repositories.ProductRepository;
import beetle.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainServise {


    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductsInReceiptsRepository productsInReceiptsRepository;

    //Create List with products for cart
    public List<Product> productsInCart = new ArrayList<>();

    // Block for saving objects to DB
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void addProduct(Product product){
        productRepository.save(product);
    }

    @Transactional
    public void addReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Transactional
    public void addProductsInReceipt(ProductsInReseipt productsInReseipt){
      productsInReceiptsRepository.save(productsInReseipt);
    }

    //Block for getting all objects from DB
    @Transactional(readOnly = true)
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Receipt> findAllReceipt(){
        return receiptRepository.findAll();
    }
    @Transactional(readOnly = true)
    public List<ProductsInReseipt> findAllProductsInReceipr(){
        return productsInReceiptsRepository.findAll();
    }

    //Find By id
    @Transactional(readOnly = true)
     public User findUser(long id) {
        return userRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Product findProduct(long id) {
        return productRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Receipt findReceipt(long id) {
        return receiptRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Receipt findByUser(User user) {
        return receiptRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public List<ProductsInReseipt> findByReceiptId(long id){
        return productsInReceiptsRepository.findByReceipt_id(id);
    }

    @Transactional
    public void deleteReceipt(long[] idList) {
        for (long id : idList)
            productsInReceiptsRepository.delete(id);
    }




    //Adding product to cart by User
    @Transactional
    public void addToCart(Long id) {
        productsInCart.add(findProduct(id));
    }

    // Return products in cart
    public List<Product> productsToCart(){
        return productsInCart;
    }
}
