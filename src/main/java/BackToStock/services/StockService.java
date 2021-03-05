package BackToStock.services;

import BackToStock.pojo.Product;
import BackToStock.pojo.User;
import BackToStock.services.BackToStockService;

import java.util.*;

public class StockService implements BackToStockService {

    public void subscribe(User user, Product product) {
        if (product!=null) {
            product.getQueue().orderedAdd(user);
        }
        else {
            System.out.println("Invalid product");
        }
    }

    public List<User> subscribedUsers(Product product) {
        if (product!=null) {
            return product.getQueue();
        }
        else {
            System.out.println("Invalid product");
            return new LinkedList<>();
        }
    }

    public void show (Product product) {
        if (product!=null) {
            System.out.println(product.getQueue());
        }
        else {
            System.out.println("Invalid product");
        }
    }

    public void itemAppeared (Product product) {
        if (product!=null) {
            User user = product.getQueue().poll();
            System.out.println(user + " received the product and got out of the queue");
        }
        else {
            System.out.println("Invalid product");
        }

    }

}
