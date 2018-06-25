package poslovnaBanka.racuni;

import java.util.Date;

public class RacuniLica {

    private long id;
    private String br_racuna;
    private Date datum_otvaranja;
    private boolean vazeci;

    public RacuniLica(){

    }

    public RacuniLica(String br_racuna, Date datum_otvaranja, boolean vazeci) {
        this.br_racuna = br_racuna;
        this.datum_otvaranja = datum_otvaranja;
        this.vazeci = vazeci;
    }

    public long getId() {
        return id;
    }


    public String getBr_racuna() {
        return br_racuna;
    }

    public void setBr_racuna(String br_racuna) {
        this.br_racuna = br_racuna;
    }

    public Date getDatum_otvaranja() {
        return datum_otvaranja;
    }

    public void setDatum_otvaranja(Date datum_otvaranja) {
        this.datum_otvaranja = datum_otvaranja;
    }

    public boolean isVazeci() {
        return vazeci;
    }

    public void setVazeci(boolean vazeci) {
        this.vazeci = vazeci;
    }
}