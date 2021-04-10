package model;

public class Client {

    private String doc;
    private long id;

    public Client(String doc, long id) {
        this.doc = doc;
        this.id = id;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
