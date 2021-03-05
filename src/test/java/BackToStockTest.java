import BackToStock.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BackToStockTest {

    BackToStockService stockService;
    LinkedList<User> testListOfUsers;
    Product product1;
    Product product2;

    @Before
    public void setUp() {
        stockService = new StockService();
        Random random = new Random();
        testListOfUsers = new LinkedList<>();

        testListOfUsers.add(new User("TestUser1", false, 20));
        testListOfUsers.add(new User("TestUser2", true, 75));
        testListOfUsers.add(new User("TestUser3", true, 58));
        testListOfUsers.add(new User("TestUser4", false, 80));
        testListOfUsers.add(new User("TestUser5", true, 85));
        testListOfUsers.add(new User("TestUser6", false, 60));
        testListOfUsers.add(new User("TestUser7", false, 70));
        testListOfUsers.add(new User("TestUser8", true, 80));
        testListOfUsers.add(new User("TestUser9", false, 40));
        testListOfUsers.add(new User("TestUser10", true, 30));


        product1 = new Product("1", ProductCategory.MEDICAL);
        product2 = new Product("2", ProductCategory.BOOKS);
    }
    @Test
    public void  subscribe_TrySubscribeInvalidProduct_True() {
        //GIVEN
        User usert1 = new User("TestUser1", false, 80);
        User usert2 = new User("TestUser2", true, 80);
        LinkedList <User> expected= new LinkedList<>();
        expected.add(usert2);
        expected.add(usert1);
        //WHEN
        stockService.subscribe(null, null);
        stockService.subscribe(usert1, product2);
        stockService.subscribe(usert2, product2);
        //THEN
        Assert.assertEquals(expected, stockService.subscribedUsers(product2));
    }
    @Test
    public void  subscribe_IsQueueCorrect_True() {
        //GIVEN
        LinkedList <User> expected= new LinkedList<>();
        LinkedList <User> expected2= new LinkedList<>();

        expected.add(testListOfUsers.get(1)); expected.add(testListOfUsers.get(2));
        expected.add(testListOfUsers.get(3)); expected.add(testListOfUsers.get(4));
        expected.add(testListOfUsers.get(7)); expected.add(testListOfUsers.get(9));
        expected.add(testListOfUsers.get(0)); expected.add(testListOfUsers.get(5));
        expected.add(testListOfUsers.get(6)); expected.add(testListOfUsers.get(8));

        expected2.add(testListOfUsers.get(1)); expected2.add(testListOfUsers.get(2));
        expected2.add(testListOfUsers.get(4)); expected2.add(testListOfUsers.get(7));
        expected2.add(testListOfUsers.get(9)); expected2.add(testListOfUsers.get(3));
        expected2.add(testListOfUsers.get(0)); expected2.add(testListOfUsers.get(5));
        expected2.add(testListOfUsers.get(6)); expected2.add(testListOfUsers.get(8));
        //WHEN
        for (int i = 0; i < 10; i++) {
            stockService.subscribe(testListOfUsers.get(i), product1);
            stockService.subscribe(testListOfUsers.get(i), product2);
        }
        //THEN
        Assert.assertEquals(expected, stockService.subscribedUsers(product1));
        Assert.assertEquals(expected2, stockService.subscribedUsers(product2));
    }
    @Test
    public void  subscribedUsers_IsGetEmptyQueueCorrect_True() {
        //GIVEN
        Product product = new Product("1", ProductCategory.MEDICAL);
        //WHEN
        Assert.assertEquals(new LinkedList<>(), stockService.subscribedUsers(product));
    }
    @Test
    public void subscribedUsers_TryGetFromNullQueue_True() {
        //WHEN
        Assert.assertEquals(new LinkedList<>(), stockService.subscribedUsers(null));
    }
    @Test
    public void show_TryShowNullQueue_True() {
        //WHEN
        try {
            stockService.show(null);
        }
        catch (NullPointerException e) {
            Assert.fail();
        }
    }
    @Test
    public void  itemAppeared_TryGetFromEmptyQueue_True() {
        //GIVEN
        Product product = new Product("1", ProductCategory.MEDICAL);
        //WHEN
        try {
            stockService.itemAppeared(product);
        }
        catch (NullPointerException | IllegalArgumentException e) {
            Assert.fail();
        }
    }
    @Test
    public void  itemAppeared_TryGetFromNullQueue_True() {
        try {
            stockService.itemAppeared(null);
        }
        catch (NullPointerException | IllegalArgumentException e) {
            Assert.fail();
        }
    }
}
