package service;

import java.util.List;
import model.Product;
import model.ClickLog;


public class AdminService {

    
    public void viewFlaggedProducts(List<Product> products) {
        System.out.println("\n🚨 Reviewing Flagged Products:");
        boolean hasFlagged = false;

        for (Product product : products) {
            if (product.isFlagged()) {
                System.out.println(product);
                hasFlagged = true;
            }
        }

        if (!hasFlagged) {
            System.out.println("✅ No flagged products found in the system.");
        }
    }

    
    public void viewClickLogs(List<ClickLog> logs) {
        System.out.println("\n📊 Viewing Click Logs:");
        if (logs.isEmpty()) {
            System.out.println("No user clicks recorded yet.");
            return;
        }

        for (ClickLog log : logs) {
            log.displayLog();  // Uses the display method from ClickLog class
        }
    }
}
