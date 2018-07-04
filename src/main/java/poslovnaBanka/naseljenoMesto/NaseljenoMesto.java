package poslovnaBanka.naseljenoMesto;

import poslovnaBanka.drzava.Drzava;

import javax.persistence.*;

@Entity
@Table(name = "NaseljenoMesto")
public class NaseljenoMesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int sifra_mesta;
    private String naziv;
    private String ptt_oznaka;

    @ManyToOne(fetch = FetchType.EAGER)
    private Drzava drzava;


    public NaseljenoMesto(){

    }

    public NaseljenoMesto(int sifra_mesta, String naziv, String ptt_oznaka, Drzava drzava) {
        this.sifra_mesta = sifra_mesta;
        this.naziv = naziv;
        this.ptt_oznaka = ptt_oznaka;
        this.drzava = drzava;

    }

    public long getId() {
        return id;
    }


    public int getSifra_mesta() {
        return sifra_mesta;
    }

    public void setSifra_mesta(int sifra_mesta) {
        this.sifra_mesta = sifra_mesta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPtt_oznaka() {
        return ptt_oznaka;
    }

    public void setPtt_oznaka(String ptt_oznaka) {
        this.ptt_oznaka = ptt_oznaka;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }
}
