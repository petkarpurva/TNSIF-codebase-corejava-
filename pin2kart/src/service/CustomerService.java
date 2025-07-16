package service;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Product;


public class CustomerService {

    
    public static List<Customer> customers = new ArrayList<>();

    
    public void createCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("👤 New customer created: " + customer.getUsername());
    }

    
    public void addToWishlist(Customer customer, Product product) {
        customer.getWishlist().add(product);
        System.out.println("💖 Added to wishlist: " + product.getName());
    }

    
    public void showWishlist(Customer customer) {
        List<Product> wishlist = customer.getWishlist();

        System.out.println("\n📝 Your Wishlist:");
        if (wishlist.isEmpty()) {
            System.out.println("✨ Your wishlist is currently empty.");
        } else {
            for (Product product : wishlist) {
                System.out.println(product);
            }
        }
    }
}
