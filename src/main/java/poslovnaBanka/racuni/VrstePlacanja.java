package poslovnaBanka.racuni;

import javax.persistence.*;

@Entity
@Table(name = "VrstePlacanja")
public class VrstePlacanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int oznaka;
    private String naziv;

    public VrstePlacanja(){

    }

    public VrstePlacanja(int oznaka, String naziv) {
        this.oznaka = oznaka;
        this.naziv = naziv;
    }

    public long getId() {
        return id;
    }


    public int getOznaka() {
        return oznaka;
    }

    public void setOznaka(int oznaka) {
        this.oznaka = oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
