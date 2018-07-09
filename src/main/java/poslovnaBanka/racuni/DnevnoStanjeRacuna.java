package poslovnaBanka.racuni;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "DnevnoStanjeRacuna")
public class DnevnoStanjeRacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private Date datum_prometa;

    @NotNull
    private double prethodno_stanje;

    @NotNull
    private double promet_korist; // kome se salje

    @NotNull
    private double promet_teren; // ko salje

    @NotNull
    private double novo_stanje;

    @ManyToOne
    private RacuniLica racuniLica;


    public DnevnoStanjeRacuna(){

    }

    public DnevnoStanjeRacuna(Date datum_prometa, double prethodno_stanje, double promet_korist, double promet_teren, double novo_stanje, RacuniLica racuniLica) {

        this.datum_prometa = datum_prometa;
        this.prethodno_stanje = prethodno_stanje;
        this.promet_korist = promet_korist;
        this.promet_teren = promet_teren;
        this.novo_stanje = novo_stanje;
        this.racuniLica = racuniLica;
    }

    public RacuniLica getRacuniLica() {
        return racuniLica;
    }

    public void setRacuniLica(RacuniLica racuniLica) {
        this.racuniLica = racuniLica;
    }

    public long getId() {
        return id;
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
