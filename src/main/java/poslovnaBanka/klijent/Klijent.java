package poslovnaBanka.klijent;

import java.util.Date;

public class Klijent {

    private long id;
    private String naziv;
    private String email;
    private String adresa;
    private String br_telefona;
    private Date datum_registracije;

    public Klijent(){

    }

    public Klijent(String naziv, String email, String adresa, String br_telefona, Date datum_registracije) {

        this.naziv = naziv;
        this.email = email;
        this.adresa = adresa;
        this.br_telefona = br_telefona;
        this.datum_registracije = datum_registracije;
    }

    public long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBr_telefona() {
        return br_telefona;
    }

    public void setBr_telefona(String br_telefona) {
        this.br_telefona = br_telefona;
    }

    public Date getDatum_registracije() {
        return datum_registracije;
    }

    public void setDatum_registracije(Date datum_registracije) {
        this.datum_registracije = datum_registracije;
    }
}