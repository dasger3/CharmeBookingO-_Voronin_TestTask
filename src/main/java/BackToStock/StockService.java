package BackToStock;

import java.util.*;

public class StockService implements BackToStockService {

    public void subscribe(User user, Product product) {
        try {
            product.getQueue().orderedAdd(user);
        }
        catch (NullPointerException e) {
            System.out.println("Invalid product");
        }

    }

    public List<User> subscribedUsers(Product product) {
        try {
            return product.getQueue();
        }
        catch (NullPointerException e) {
            System.out.println("Invalid product");
        }
        return new LinkedList<>();

    }

    public void show (Product product) {
        try {
            System.out.println(product.getQueue());
        }
        catch (NullPointerException e) {
            System.out.println("Invalid product");
        }
        //ListIterator<BackToStock.User> userIter = product.getQueue().listIterator();
        //while (userIter.hasNext()) {
            //System.out.println(userIter.next());
        //}
    }

    public void itemAppeared (Product product) {
        try {
            User user = product.getQueue().poll();
            System.out.println(user + " received the product and got out of the queue");
        }
        catch (NullPointerException e) {
            System.out.println("Invalid product");
        }

    }

}
