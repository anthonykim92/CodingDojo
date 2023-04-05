public class CafeJava {
    public static void main(String[] args) {
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        String orderedMessage = "Ordered a "; 
        
        String mocha = "Mocha"; 
        String drip = "Drip Coffee"; 
        String latte = "Latte(s)"; 
        String cappucino = "Cappucino"; 
        
        
        
        double mochaPrice = 3.5;
        double dripcoffePrice = 2.5;
        double lattePrice = 4.5;
        double cappucinoPrice = 4.5;

        
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
    
        System.out.println(customer1 + orderedMessage + drip);
        System.out.println(customer4 + orderedMessage + cappucino );
        System.out.println(customer2 + orderedMessage + 2 +latte );
        System.out.println(customer3 + displayTotalMessage + (lattePrice - dripcoffePrice));
        
        if (isReadyOrder4 = true){
        System.out.println(customer4 + readyMessage + cappucino ); 
        System.out.println(customer2 + displayTotalMessage + (lattePrice + lattePrice));};

        if (isReadyOrder2 = true){
            System.out.println(customer2 + readyMessage + cappucino );
            }
        if (isReadyOrder2 = false){
            System.out.println(customer2 + pendingMessage);
            }
        }

    }
