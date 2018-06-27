package poslovnaBanka.klijent;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PravnoLice")
public class PravnoLice extends Klijent {

    private String PIB;


    public PravnoLice(){

    }

    public PravnoLice(String PIB) {
        this.PIB = PIB;
    }

    public PravnoLice(String naziv, String email, String adresa, String br_telefona, Date datum_registracije, String PIB) {
        super(naziv, email, adresa, br_telefona, datum_registracije);
        this.PIB = PIB;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }
}
