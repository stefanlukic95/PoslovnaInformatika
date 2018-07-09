package poslovnaBanka.kurs;

import poslovnaBanka.banka.Banka;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KursnaLista")
public class KursnaLista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date datum;
    private String br_kursnel;
    private Date primena_od;

    @ManyToOne
    private Banka banka;


    public KursnaLista(){

    }

    public KursnaLista(Date datum, String br_kursnel, Date primena_od, Banka banka) {
        this.datum = datum;
        this.br_kursnel = br_kursnel;
        this.primena_od = primena_od;
        this.banka = banka;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
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
