public class Slide {
    private int burgers = 0;
    private int ammountOfCustomers = 0;

    public synchronized void makeBurger(){
        while(burgers>7){
            try{
                wait(); //Lytter til notify() fra andre threads
            } catch (Exception e){
                System.out.println("Exception :o");
            }
        }
        burgers = burgers + 1;
        notifyAll(); //Fortæl den anden tråd at nu er burgers ændret
    }

    public int getAmmountOfCustomers() {
        return ammountOfCustomers;
    }

    public synchronized void serveBurger(){
        while (burgers<1){
            try {
                wait();
            } catch (Exception e){
                System.out.println("Exception :o");
            }
        }
        burgers = burgers -1;
        ammountOfCustomers = ammountOfCustomers -1;
        System.out.println("Customers left: " + ammountOfCustomers + "\nAmmount of burgers in slide: " + burgers);
        notifyAll();
    }

    public int getBurgers() {
        return burgers;
    }

    public Slide(int ammountOfCustomers) {
        this.ammountOfCustomers = ammountOfCustomers;
    }
}
