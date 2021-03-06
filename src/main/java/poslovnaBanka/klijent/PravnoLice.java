package poslovnaBanka.klijent;

import poslovnaBanka.racuni.RacuniLica;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "PravnoLice")
public class PravnoLice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String naziv;

    @NotNull
    private String email;

    @NotNull
    private String adresa;

    @NotNull
    private String br_telefona;

    private Date datum_registracije;

    @NotNull
    private String pib;




    public PravnoLice(){

    }

    public PravnoLice(String naziv, String email, String adresa, String br_telefona, Date datum_registracije, String PIB) {
        this.naziv = naziv;
        this.email = email;
        this.adresa = adresa;
        this.br_telefona = br_telefona;
        this.datum_registracije = datum_registracije;
        this.pib = PIB;

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

    public String getPIB() {
        return pib;
    }

    public void setPIB(String PIB) {
        this.pib = PIB;
    }
}
