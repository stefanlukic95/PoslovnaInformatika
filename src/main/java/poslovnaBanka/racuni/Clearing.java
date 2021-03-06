package poslovnaBanka.racuni;

import com.fasterxml.jackson.annotation.JsonIgnore;
import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Clearing")
public class Clearing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_poruke;
    private double ukupan_iznos;
    private Date datum;

    @OneToMany
    @JsonIgnore
    private List<AnalitikaIzvoda> pojedinacnoPlacanje;

    public Clearing(){
        this.ukupan_iznos = 0;
        this.pojedinacnoPlacanje = new ArrayList<AnalitikaIzvoda>();
    }

    public Clearing(String id_poruke, double ukupan_iznos, Date datum) {
        this.id_poruke = id_poruke;
        this.ukupan_iznos = ukupan_iznos;
        this.datum = datum;
        this.pojedinacnoPlacanje = new ArrayList<AnalitikaIzvoda>();
    }

    public long getId() {
        return id;
    }

    public List<AnalitikaIzvoda> getPojedinacnoPlacanje() {
        return pojedinacnoPlacanje;
    }

    public void setPojedinacnoPlacanje(List<AnalitikaIzvoda> pojedinacnoPlacanje) {
        this.pojedinacnoPlacanje = pojedinacnoPlacanje;
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
