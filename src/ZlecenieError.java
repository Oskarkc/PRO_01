public class ZlecenieError extends RuntimeException{
    public ZlecenieError(){
        super("Zlecenie nie posiada brygady lub prac do wykonania!");
    }
}
