public class Slide {
    //Declare to ints
    private int burgers = 0;
    private int ammountOfCustomers = 0;

    //Declare en metode til at incremate burger
    public synchronized void makeBurger(){
        while(burgers>7){
            try{
                wait(); //Lytter til notify(), el. notifyAll() fra andre threads
            } catch (Exception e){
                System.out.println("Exception was caught");
            }
        }
        burgers = burgers + 1;
        //Laver et sout til at kunne følge med i hvad programmet laver
        System.out.println("Made a burger! \nAmmount of burgers in the slide: " + burgers + "\n");
        notifyAll(); //Fortæl den anden tråd at nu er burgers ændret
    }

    public synchronized void serveBurger(){
        //Første loop sætter threaden til wait hvis burgers er 0 eller mindre
        while (burgers<1){
            try {
                wait();
            } catch (Exception e){
                System.out.println("Exception was caught");
            }
        }
        //Her decrementer jeg både ammountOfCustomers og burgers samt laver
        //et sout til at holde øje med hvor mange der er tilbage af hver
        burgers = burgers -1;
        ammountOfCustomers = ammountOfCustomers -1;
        System.out.println("Served a customer!\nCustomers left: " + ammountOfCustomers +
                           "\nAmmount of burgers remaining in slide: " + burgers + "\n");
        //Laver en notifyAll() der vækker alle threads der er 'waiting'
        notifyAll();
    }

    public int getAmmountOfCustomers() {
        return ammountOfCustomers;
    }

    public int getBurgers() {
        return burgers;
    }

    public Slide(int ammountOfCustomers) {
        this.ammountOfCustomers = ammountOfCustomers;
    }
}
