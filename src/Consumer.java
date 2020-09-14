public class Consumer implements Runnable{
    private Slide slide;

    public Consumer(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void run(){
        while(slide.getAmmountOfCustomers()>0){
            slide.serveBurger();
        }
    }
}
