package exceptions;

public class ExceptionGoberment extends Exception {

    private long docInt;
    private int day;

    public ExceptionGoberment(long docInt, int day) {
        super("Usted por ley gubernamental. No deberia estar fuera de casa");
        this.docInt = docInt;
        this.day = day;
    }

    public long getDocInt() {
        return docInt;
    }

    public int getDay() {
        return day;
    }
}
