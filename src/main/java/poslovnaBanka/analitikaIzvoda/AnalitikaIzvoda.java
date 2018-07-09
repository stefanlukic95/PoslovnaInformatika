package poslovnaBanka.analitikaIzvoda;

import poslovnaBanka.naseljenoMesto.NaseljenoMesto;
import poslovnaBanka.racuni.DnevnoStanjeRacuna;
import poslovnaBanka.racuni.RacuniLica;
import poslovnaBanka.racuni.VrstePlacanja;
import poslovnaBanka.valute.Valute;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "AnalitikaIzvoda")
public class AnalitikaIzvoda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long br_stavke;
    @NotNull
    private String duznik;

    @NotNull
    private String svrha_placanja;

    @NotNull
    private String poverilac_primalac;

    @NotNull
    private Date datum_prijema;

    @NotNull
    private Date datum_valute;

    @ManyToOne
    private RacuniLica racun_duznika;

    private int model_zaduzenja;

    private String poziv_na_brZ; //zaduzenja

    @ManyToOne
    private String racun_poverioca; // racun banke

    private int model_odobrenja;

    private String poziv_na_brO; //odobrenja

    private boolean hitno;

    private double iznos;

    private int tip_greske;

    private String status;

    @ManyToOne
    private Valute valuta;

    @ManyToOne
    private VrstePlacanja vrstaPlacanja;

    @OneToOne
    private DnevnoStanjeRacuna dnevnoStanjeRacuna;

    @ManyToOne
    private NaseljenoMesto naseljenoMesto;


    public AnalitikaIzvoda(){

    }

    public AnalitikaIzvoda(long br_stavke, String duznik, String svrha_placanja, String poverilac_primalac, Date datum_prijema, Date datum_valute, RacuniLica racun_duznika, int model_zaduzenja, String poziv_na_brZ, String racun_poverioca, int model_odobrenja, String poziv_na_brO, boolean hitno, double iznos, int tip_greske, String status, Valute valuta, VrstePlacanja vrstaPlacanja, DnevnoStanjeRacuna dnevnoStanjeRacuna, NaseljenoMesto naseljenoMesto) {
        this.br_stavke = br_stavke;
        this.duznik = duznik;
        this.svrha_placanja = svrha_placanja;
        this.poverilac_primalac = poverilac_primalac;
        this.datum_prijema = datum_prijema;
        this.datum_valute = datum_valute;
        this.racun_duznika = racun_duznika;
        this.model_zaduzenja = model_zaduzenja;
        this.poziv_na_brZ = poziv_na_brZ;
        this.racun_poverioca = racun_poverioca;
        this.model_odobrenja = model_odobrenja;
        this.poziv_na_brO = poziv_na_brO;
        this.hitno = hitno;
        this.iznos = iznos;
        this.tip_greske = tip_greske;
        this.status = status;
        this.valuta = valuta;
        this.vrstaPlacanja = vrstaPlacanja;
        this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
        this.naseljenoMesto = naseljenoMesto;
    }

    public long getId() {
        return id;
    }


    public long getBr_stavke() {
        return br_stavke;
    }

    public void setBr_stavke(long br_stavke) {
        this.br_stavke = br_stavke;
    }

    public void setModel_odobrenja(int model_odobrenja) {
        this.model_odobrenja = model_odobrenja;
    }

    public VrstePlacanja getVrstaPlacanja() {
        return vrstaPlacanja;
    }

    public void setVrstaPlacanja(VrstePlacanja vrstaPlacanja) {
        this.vrstaPlacanja = vrstaPlacanja;
    }

    public DnevnoStanjeRacuna getDnevnoStanjeRacuna() {
        return dnevnoStanjeRacuna;
    }

    public void setDnevnoStanjeRacuna(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
        this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
    }

    public NaseljenoMesto getNaseljenoMesto() {
        return naseljenoMesto;
    }

    public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
        this.naseljenoMesto = naseljenoMesto;
    }

    public String getDuznik() {
        return duznik;
    }

    public void setDuznik(String duznik) {
        this.duznik = duznik;
    }

    public String getSvrha_placanja() {
        return svrha_placanja;
    }

    public void setSvrha_placanja(String svrha_placanja) {
        this.svrha_placanja = svrha_placanja;
    }

    public String getPoverilac_primalac() {
        return poverilac_primalac;
    }

    public void setPoverilac_primalac(String poverilac_primalac) {
        this.poverilac_primalac = poverilac_primalac;
    }

    public Date getDatum_prijema() {
        return datum_prijema;
    }

    public void setDatum_prijema(Date datum_prijema) {
        this.datum_prijema = datum_prijema;
    }

    public Date getDatum_valute() {
        return datum_valute;
    }

    public void setDatum_valute(Date datum_valute) {
        this.datum_valute = datum_valute;
    }

    public RacuniLica getRacun_duznika() {
        return racun_duznika;
    }

    public void setRacun_duznika(RacuniLica racun_duznika) {
        this.racun_duznika = racun_duznika;
    }

    public int getModel_zaduzenja() {
        return model_zaduzenja;
    }

    public void setModel_zaduzenja(int model_zaduzenja) {
        this.model_zaduzenja = model_zaduzenja;
    }

    public String getPoziv_na_brZ() {
        return poziv_na_brZ;
    }

    public void setPoziv_na_brZ(String poziv_na_brZ) {
        this.poziv_na_brZ = poziv_na_brZ;
    }

    public String getRacun_poverioca() {
        return racun_poverioca;
    }

    public void setRacun_poverioca(String racun_poverioca) {
        this.racun_poverioca = racun_poverioca;
    }

    public int getModel_odobrenja() {
        return model_odobrenja;
    }

    public void setPozic_na_brO(String pozic_na_brO) {
        this.poziv_na_brO = pozic_na_brO;
    }

    public boolean isHitno() {
        return hitno;
    }

    public void setHitno(boolean hitno) {
        this.hitno = hitno;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public int getTip_greske() {
        return tip_greske;
    }

    public void setTip_greske(int tip_greske) {
        this.tip_greske = tip_greske;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoziv_na_brO() {
        return poziv_na_brO;
    }

    public void setPoziv_na_brO(String poziv_na_brO) {
        this.poziv_na_brO = poziv_na_brO;
    }

    public Valute getValuta() {
        return valuta;
    }

    public void setValuta(Valute valuta) {
        this.valuta = valuta;
    }
}
