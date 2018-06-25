package poslovnaBanka.kurs;

import java.util.Date;

public class KursnaLista {

    private long id;
    private Date datum;
    private String br_kursnel;
    private Date primena_od;


    public KursnaLista(){

    }

    public KursnaLista(Date datum, String br_kursnel, Date primena_od) {
        this.datum = datum;
        this.br_kursnel = br_kursnel;
        this.primena_od = primena_od;
    }

    public long getId() {
        return id;
    }


    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getBr_kursnel() {
        return br_kursnel;
    }

    public void setBr_kursnel(String br_kursnel) {
        this.br_kursnel = br_kursnel;
    }

    public Date getPrimena_od() {
        return primena_od;
    }

    public void setPrimena_od(Date primena_od) {
        this.primena_od = primena_od;
    }
}
