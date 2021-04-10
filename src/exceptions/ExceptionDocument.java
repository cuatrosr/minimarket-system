package exceptions;

public class ExceptionDocument extends Exception {

    private String document;

    public ExceptionDocument(String document) {
        super("Usted no puede entrar al establecimiento. Debe ser mayor de edad");
        this.document = document;
    }
    
    public String getDocument() {
        return document;
    }
}
