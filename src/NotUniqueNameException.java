public class NotUniqueNameException extends RuntimeException{
    public NotUniqueNameException(){
        super("There is existing class with this name");
    }
}
