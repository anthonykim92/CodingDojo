import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCafe {
    public static void main(String[] args) {

        CafeUtil appTest = new CafeUtil();


        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());


        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        List<String> loadMenu = Arrays.asList(
            "drip coffee",
            "cappucino",
            "latte",
            "mocha"
        );
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.addAll(loadMenu);
        appTest.displayMenu(menuItems);
        
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();


        for (int w = 0; w < 3; w++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        appTest.addCustomer(customers);

    }
}