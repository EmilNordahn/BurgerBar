public class Consumer implements Runnable{
    private Slide slide;

    //Constructoren kræver et Slide objekt, det gør at jeg kan have flere
    //threads der arbejder på det samme objekt i min main klasse
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
