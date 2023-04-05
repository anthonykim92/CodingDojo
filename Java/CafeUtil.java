import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(){
        int sum=0;
        for (int w = 1; w<=10; w++){
            sum+=w;
        }
        return sum;
    }
    
    public double getOrderTotal(double[] prices){
        double sum = 0; 
        for (int w = 0; w < prices.length; w++){
            sum = sum + prices[w];
            }
            return sum; 
        } 
    public void displayMenu(ArrayList<String> menuItems){
        for (int w = 0; w < menuItems.size(); w++){
            System.out.printf("%s %s\n",w, menuItems.get(w));
        }
    }
    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name!");
        String userName = System.console().readLine();
        System.out.println(("Hello" + userName));
        System.out.printf("There are %s people in front of you." , customers.size());
        customers.add(userName); 

    }
}

