public class Gorilla extends Mammal{
    public Gorilla(int energy) {
		super(energy);
    }
    public void throwSomething(){
        System.out.println("The Gorilla has thrown something");
        energy -=5; 
        displayEnergy();
    }
    public void eatBananas(){
        System.out.println("The Gorilla is satisfied.");
        energy +=10;
        displayEnergy();
    }
    public void climb(){
        System.out.println("The Gorilla has climbed a tree.");
        energy -=10;
        displayEnergy();
    }
    
}
