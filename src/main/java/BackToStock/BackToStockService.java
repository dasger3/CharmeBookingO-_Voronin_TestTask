package BackToStock;

import java.util.List;

public interface BackToStockService {

    void subscribe(User user, Product product);

    List<User> subscribedUsers(Product product);

    void show (Product product);

    void itemAppeared (Product product);

}
