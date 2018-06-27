package poslovnaBanka.valute;

import javax.persistence.*;

@Entity
@Table(name = "Valute")
public class Valute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int id_valute;
    private String sifra;
    private String naziv;
    private boolean domicilna;

    public Valute(){

    }

    public Valute(int id_valute, String sifra, String naziv, boolean domicilna) {
        this.id_valute = id_valute;
        this.sifra = sifra;
        this.naziv = naziv;
        this.domicilna = domicilna;
    }



    public long getId() {
        return id;
    }


    public int getId_valute() {
        return id_valute;
    }

    public void setId_valute(int id_valute) {
        this.id_valute = id_valute;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isDomicilna() {
        return domicilna;
    }

    public void setDomicilna(boolean domicilna) {
        this.domicilna = domicilna;
    }
}
