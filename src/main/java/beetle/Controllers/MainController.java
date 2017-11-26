package beetle.Controllers;

import beetle.Entities.Product;
import beetle.Entities.ProductsInReseipt;
import beetle.Entities.Receipt;
import beetle.Entities.User;
import beetle.Services.MainServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Temporal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private MainServise mainServise;

    //Return home-page
    @RequestMapping("/")
    public String index(Model model) {

        List<Product> products = mainServise
                .findAllProduct();

        model.addAttribute("products",products);

        return "index";
    }
    //return page with all users
    @RequestMapping("/show_users")
    public String framesVeiw(Model model) {

        List<User> users = mainServise
                .findAllUser();

        model.addAttribute("users", users);

        return "users";
    }
    //Create receipt for user
    @RequestMapping(value="/getReceipt", method = RequestMethod.POST)
    public String frameAdd(Model model,
            @RequestParam String name,
            @RequestParam String email) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        String textData = sdf.format(date);
        User user = new User(name,email);
        List<User> users = mainServise.findAllUser();

        mainServise.addUser(user);

        List<Product> products = mainServise.productsToCart();

        mainServise.addReceipt(new Receipt(textData,user,products));

        Receipt receipt = mainServise.findByUser(user);

        long receiptId = receipt.getId();

        //Add products and user to receipt for admin
        for (Product product : products) {
            mainServise.addProductsInReceipt(new ProductsInReseipt(receiptId, product.getId(),user.getName(),user.getEmail(), receipt.getDate()));
        }

        model.addAttribute("user", user);
        model.addAttribute("products", products);
        model.addAttribute("receiptId", receiptId);

        return "receipt";
    }

    @RequestMapping(value="/admin")
    public String adminMenu(Model model) {

        List<ProductsInReseipt> productsInReseipts = mainServise.findAllProductsInReceipr();

        model.addAttribute("productsInReseipts",productsInReseipts);

        return "admin";
    }

    @RequestMapping("/addToCart/{id}")
    public ResponseEntity<Void> addToCart(
            @PathVariable(value = "id") Long id) {

        mainServise.addToCart(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/cart")
    public String goToCart(Model model) {

        List<Product> products = mainServise.productsToCart();

        model.addAttribute("products",products);

        return "cart";
    }
}
