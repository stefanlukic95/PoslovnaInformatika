package poslovnaBanka.drzava;

public class Drzava {

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
}
