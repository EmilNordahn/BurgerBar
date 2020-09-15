public class Main {
    public static void main(String[] args) {
        //Laver et random tal der dikterer hvor mange kunder der er
        Slide slide = new Slide((int) (Math.random()*100));
        System.out.println("Ammount of customers today: " + slide.getAmmountOfCustomers());

        //Opretter en producer og consumer
        Producer burgerFlipper = new Producer(slide);
        Consumer burgerServer = new Consumer(slide);

        //Opretter to threads, en til hver af de objekter jeg lavede tidligere
        Thread t1 = new Thread(burgerFlipper);
        Thread t2 = new Thread(burgerServer);

        //Starter de to threads
        t1.start();
        t2.start();
    }
}