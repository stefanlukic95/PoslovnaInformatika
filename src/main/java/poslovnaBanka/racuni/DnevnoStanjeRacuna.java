package poslovnaBanka.racuni;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DnevnoStanjeRacuna")
public class DnevnoStanjeRacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long br_racuna;
    private Date datum_prometa;
    private double prethodno_stanje;
    private double promet_korist;
    private double promet_teren;
    private double novo_stanje;


    public DnevnoStanjeRacuna(){

    }

    public DnevnoStanjeRacuna(long br_racuna, Date datum_prometa, double prethodno_stanje, double promet_korist, double promet_teren, double novo_stanje) {
        this.br_racuna = br_racuna;
        this.datum_prometa = datum_prometa;
        this.prethodno_stanje = prethodno_stanje;
        this.promet_korist = promet_korist;
        this.promet_teren = promet_teren;
        this.novo_stanje = novo_stanje;
    }

    public long getId() {
        return id;
    }

    public long getBr_racuna() {
        return br_racuna;
    }

    public void setBr_racuna(long br_racuna) {
        this.br_racuna = br_racuna;
    }

    public Date getDatum_prometa() {
        return datum_prometa;
    }

    public void setDatum_prometa(Date datum_prometa) {
        this.datum_prometa = datum_prometa;
    }

    public double getPrethodno_stanje() {
        return prethodno_stanje;
    }

    public void setPrethodno_stanje(double prethodno_stanje) {
        this.prethodno_stanje = prethodno_stanje;
    }

    public double getPromet_korist() {
        return promet_korist;
    }

    public void setPromet_korist(double promet_korist) {
        this.promet_korist = promet_korist;
    }

    public double getPromet_teren() {
        return promet_teren;
    }

    public void setPromet_teren(double promet_teren) {
        this.promet_teren = promet_teren;
    }

    public double getNovo_stanje() {
        return novo_stanje;
    }

    public void setNovo_stanje(double novo_stanje) {
        this.novo_stanje = novo_stanje;
    }
}
