package service;

import java.util.ArrayList;
import java.util.List;
import model.Product;


public class SearchService {

    
    public List<Product> searchByKeyword(String keyword) {
        List<Product> matchedProducts = new ArrayList<>();

        
        keyword = keyword.toLowerCase().trim();

        
        if (keyword.contains("shirt") || keyword.contains("bow")) {
            matchedProducts.add(new Product(
                    1,
                    "Red Bow",
                    799.0,
                    "Amazon",
                    0.88,
                    "https://www.amazon.in/Tuxedo-Bow-Tie-Bowtie-Necktie/dp/B01F5FY4KQ",
                    false
            ));

            matchedProducts.add(new Product(
                    2,
                    "Floral Shirt",
                    999.0,
                    "Flipkart",
                    0.82,
                    "https://www.flipkart.com/houseofcommon-men-floral-print-casual-white-shirt/p/itm16ec7036e5f3a",
                    false
            ));
        }

        if (keyword.contains("lamp")) {
            matchedProducts.add(new Product(
                    3,
                    "Vintage Lamp",
                    1299.0,
                    "Amazon",
                    0.92,
                    "https://www.amazon.in/PRIMESKY%C2%AE-Changing-Night-Beautiful-Decoration-15CM/dp/B091N6919B",
                    false
            ));
        }

       
        if (keyword.contains("137ad6168313072c64879b4eb31849c7")) {
            matchedProducts.add(new Product(
                    4,
                    "Red Bow (from Pinterest Image)",
                    799.0,
                    "Amazon",
                    0.95,
                    "https://www.amazon.in/Tuxedo-Bow-Tie-Bowtie-Necktie/dp/B01F5FY4KQ",
                    false
            ));
        }

        if (keyword.contains("f7d5433be6aac42c66f3e2b9352f128f")) {
            matchedProducts.add(new Product(
                    5,
                    "Moon Lamp - LED Night Light (from Pinterest Image)",
                    1299.0,
                    "Amazon",
                    0.96,
                    "https://www.amazon.in/PRIMESKY%C2%AE-Changing-Night-Beautiful-Decoration-15CM/dp/B091N6919B",
                    false
            ));
        }

        
        if (matchedProducts.isEmpty()) {
            System.out.println("❌ No products matched your search for: \"" + keyword + "\"");
        }

        return matchedProducts;
    }
}
