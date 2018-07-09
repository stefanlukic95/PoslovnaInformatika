package poslovnaBanka.racuni;

import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;

import javax.persistence.*;

@Entity
@Table(name = "RTGS")
public class RTGS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String id_poruke;

    @OneToOne
    private AnalitikaIzvoda analitikaIzvoda;


    public RTGS(){

    }

    public RTGS(String id_poruke, AnalitikaIzvoda analitikaIzvoda) {
        this.id_poruke = id_poruke;
        this.analitikaIzvoda = analitikaIzvoda;
    }

    public AnalitikaIzvoda getAnalitikaIzvoda() {
        return analitikaIzvoda;
    }

    public void setAnalitikaIzvoda(AnalitikaIzvoda analitikaIzvoda) {
        this.analitikaIzvoda = analitikaIzvoda;
    }

    public long getId() {
        return id;
    }

    public String getId_poruke() {
        return id_poruke;
    }

    public void setId_poruke(String id_poruke) {
        this.id_poruke = id_poruke;
    }
}
