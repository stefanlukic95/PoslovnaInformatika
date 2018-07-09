package poslovnaBanka.racuni;

import com.fasterxml.jackson.annotation.JsonFormat;
import poslovnaBanka.banka.Banka;
import poslovnaBanka.valute.Valute;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "RacuniLica")
public class RacuniLica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String br_racuna;


    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datum_otvaranja;


    private boolean vazeci;

    @OneToOne
    private Valute valute;

    @ManyToOne
    private Banka banka;

    public RacuniLica(){

    }

    public RacuniLica(String br_racuna, Date datum_otvaranja, boolean vazeci, Valute valute, Banka banka) {
        this.br_racuna = br_racuna;
        this.datum_otvaranja = datum_otvaranja;
        this.vazeci = vazeci;
        this.valute = valute;
        this.banka = banka;
    }

    public Valute getValute() {
        return valute;
    }

    public void setValute(Valute valute) {
        this.valute = valute;
    }

    public long getId() {
        return id;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
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

