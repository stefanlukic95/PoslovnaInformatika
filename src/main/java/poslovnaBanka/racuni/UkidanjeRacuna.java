package poslovnaBanka.racuni;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UkidanjeRacuna")
public class UkidanjeRacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int id_ukidanja;
    private Date datum_ukidanja;
    private String prenos_sredstva;

    public UkidanjeRacuna(){

    }

    public UkidanjeRacuna(int id_ukidanja, Date datum_ukidanja, String prenos_sredstva) {
        this.id_ukidanja = id_ukidanja;
        this.datum_ukidanja = datum_ukidanja;
        this.prenos_sredstva = prenos_sredstva;
    }

    public long getId() {
        return id;
    }

    public int getId_ukidanja() {
        return id_ukidanja;
    }

    public void setId_ukidanja(int id_ukidanja) {
        this.id_ukidanja = id_ukidanja;
    }

    public Date getDatum_ukidanja() {
        return datum_ukidanja;
    }

    public void setDatum_ukidanja(Date datum_ukidanja) {
        this.datum_ukidanja = datum_ukidanja;
    }

    public String getPrenos_sredstva() {
        return prenos_sredstva;
    }

    public void setPrenos_sredstva(String prenos_sredstva) {
        this.prenos_sredstva = prenos_sredstva;
    }
}
