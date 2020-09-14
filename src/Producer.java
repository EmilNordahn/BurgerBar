public class Producer implements Runnable{
    private Slide slide;

    public Producer(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void run(){
        while (slide.getAmmountOfCustomers()>0){
            slide.makeBurger();
        }
    }
}
