public class Producer implements Runnable{
    private Slide slide;

    //Constructoren kræver et Slide objekt, det gør at jeg kan have flere
    //threads der arbejder på det samme objekt i min main klasse
    public Producer(Slide slide) {
        this.slide = slide;
    }

    @Override
    public void run(){
        //I det her loop laver jeg en ekstra AND condition der sørger for at der aldrig
        //bliver lavet flere burgers end der er kunder tilbage
        while (slide.getAmmountOfCustomers()>0 && slide.getBurgers()< slide.getAmmountOfCustomers()){
            slide.makeBurger();
        }
    }
}
