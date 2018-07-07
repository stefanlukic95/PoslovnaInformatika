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



    public Drzava(){

    }

    public Drzava(String sifra_drzave, String naziv) {
        this.sifra_drzave = sifra_drzave;
        this.naziv = naziv;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


 /*   @Override
    public String toString() {
        return "Drzava{" +
                "id=" + id +
                ", sifra_drzave='" + sifra_drzave + '\'' +
                ", naziv=" + naziv +
                '}';
    }*/
}
