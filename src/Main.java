public class Main {
    public static void main(String[] args) {
        Slide slide = new Slide((int)(Math.random()*100));
        Producer burgerFlipper = new Producer(slide);
        Consumer burgerServer = new Consumer(slide);

        Thread t1 = new Thread(burgerFlipper);
        Thread t2 = new Thread(burgerServer);

        t1.start();
        t2.start();
    }
}