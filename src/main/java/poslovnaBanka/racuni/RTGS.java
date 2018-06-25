package poslovnaBanka.racuni;

public class RTGS {

    private long id;
    private String id_poruke;


    public RTGS(){

    }

    public RTGS(String id_poruke) {
        this.id_poruke = id_poruke;
    }

    public long getId() {
        return id;
    }

    public String getId_poruke() {
        return id_poruke;
    }

    public void setId_poruke(String id_poruke) {
        this.id_poruke = id_poruke;
    }
}
