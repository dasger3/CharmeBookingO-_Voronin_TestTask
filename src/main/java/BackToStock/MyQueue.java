package BackToStock;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyQueue<T> extends LinkedList<T> implements Comparator<T> {

    ProductCategory productCategory;
    MyQueue (ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void orderedAdd(T element) {
            ListIterator<T> itr = listIterator();
            while(true) {
                if (!itr.hasNext()) {
                    itr.add(element);
                    break;
                }

                T elementInList = itr.next();
                if (compare(elementInList, element) > 0) {
                    itr.previous();
                    itr.add(element);
                    break;
                }
            }
        }

    @Override
    public int compare(T user1, T user2) {
        return Integer.compare(getPriority((User) user2, productCategory), getPriority((User) user1, productCategory));
    }
    public int getPriority (User user, ProductCategory productCategory) {
        if (user.isPremium())  return 2;
        if (user.getAge() > 70) {
            if (productCategory == ProductCategory.MEDICAL) return 2;
            return 1;
        }
        return 0;
    }
}
