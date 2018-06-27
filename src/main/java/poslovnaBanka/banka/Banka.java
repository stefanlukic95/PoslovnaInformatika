package poslovnaBanka.banka;

import javax.persistence.*;

@Entity
@Table(name = "Banka")
public class Banka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String sifra_banke;
    private String PIB;
    private String naziv;
    private String adresa;
    private String email;
    private String web;
    private String telefon;
    private String fax;
    private boolean banka;
    private String swift_kod;
    private String obracunski_racun;

    public Banka(){

    }

    public Banka(String sifra_banke, String PIB, String naziv, String adresa, String email, String web, String telefon, String fax, boolean banka, String swift_kod, String obracunski_racun) {
        this.sifra_banke = sifra_banke;
        this.PIB = PIB;
        this.naziv = naziv;
        this.adresa = adresa;
        this.email = email;
        this.web = web;
        this.telefon = telefon;
        this.fax = fax;
        this.banka = banka;
        this.swift_kod = swift_kod;
        this.obracunski_racun = obracunski_racun;
    }

    public long getId() {
        return Id;
    }

    public String getSifra_banke() {
        return sifra_banke;
    }

    public void setSifra_banke(String sifra_banke) {
        this.sifra_banke = sifra_banke;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public boolean isBanka() {
        return banka;
    }

    public void setBanka(boolean banka) {
        this.banka = banka;
    }

    public String getSwift_kod() {
        return swift_kod;
    }

    public void setSwift_kod(String swift_kod) {
        this.swift_kod = swift_kod;
    }

    public String getObracunski_racun() {
        return obracunski_racun;
    }

    public void setObracunski_racun(String obracunski_racun) {
        this.obracunski_racun = obracunski_racun;
    }
}
