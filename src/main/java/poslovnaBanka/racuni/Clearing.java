package poslovnaBanka.racuni;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Clearing")
public class Clearing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_poruke;
    private double ukupan_iznos;
    private Date datum;

    public Clearing(){

    }

    public Clearing(String id_poruke, double ukupan_iznos, Date datum) {
        this.id_poruke = id_poruke;
        this.ukupan_iznos = ukupan_iznos;
        this.datum = datum;
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

    public double getUkupan_iznos() {
        return ukupan_iznos;
    }

    public void setUkupan_iznos(double ukupan_iznos) {
        this.ukupan_iznos = ukupan_iznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
