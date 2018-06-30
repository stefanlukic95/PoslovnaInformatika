package poslovnaBanka.drzava;

import poslovnaBanka.naseljenoMesto.NaseljenoMesto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Drzave")
public class Drzava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sifra_drzave;
    private String naziv;
    @ManyToOne
    private NaseljenoMesto naseljenoMesto;


    public Drzava(){

    }

    public Drzava(String sifra_drzave, String naziv, NaseljenoMesto naseljenoMesto) {
        this.sifra_drzave = sifra_drzave;
        this.naziv = naziv;
        this.naseljenoMesto = naseljenoMesto;
    }

    public long getId() {
        return id;
    }


    public String getSifra_drzave() {
        return sifra_drzave;
    }

    public void setSifra_drzave(String sifra_drzave) {
        this.sifra_drzave = sifra_drzave;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public NaseljenoMesto getNaseljenoMesto() {
        return naseljenoMesto;
    }

    public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
        this.naseljenoMesto = naseljenoMesto;
    }

 /*   @Override
    public String toString() {
        return "Drzava{" +
                "id=" + id +
                ", sifra_drzave='" + sifra_drzave + '\'' +
                ", naziv=" + naziv +
                '}';
    }*/
}
