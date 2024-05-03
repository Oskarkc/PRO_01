public class NotUniqueNameException extends RuntimeException{
    public NotUniqueNameException(){
        super("Istnieje dzial z taka nazwa");
    }
}
