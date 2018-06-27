package poslovnaBanka.klijent;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name ="FizickoLice")
public class FizickoLice extends Klijent {

    private String br_licnek;


    public FizickoLice(){

    }

    public FizickoLice(String br_licnek) {
        this.br_licnek = br_licnek;
    }

    public FizickoLice(String naziv, String email, String adresa, String br_telefona, Date datum_registracije, String br_licnek) {
        super(naziv, email, adresa, br_telefona, datum_registracije);
        this.br_licnek = br_licnek;
    }

    public String getBr_licnek() {
        return br_licnek;
    }

    public void setBr_licnek(String br_licnek) {
        this.br_licnek = br_licnek;
    }
}
