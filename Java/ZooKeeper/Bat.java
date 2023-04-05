public class Bat extends Mammal {
    public Bat(){
        super(300);
        
    }

    void fly(){
        System.out.println("-Screeeech");
        energy -= 50;
        displayEnergy();
    }

    void eatHumans(){
        System.out.println("Yum.");
        energy += 25;
        displayEnergy();
    }

    void attackTown(){
        System.out.println("Ouch.");
        energy -= 100;
        displayEnergy();
    }
}