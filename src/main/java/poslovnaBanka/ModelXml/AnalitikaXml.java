package poslovnaBanka.ModelXml;

import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;
import poslovnaBanka.naseljenoMesto.NaseljenoMesto;
import poslovnaBanka.racuni.DnevnoStanjeRacuna;
import poslovnaBanka.racuni.RacuniLica;
import poslovnaBanka.racuni.VrstePlacanja;
import poslovnaBanka.valute.Valute;

import java.text.SimpleDateFormat;


public class AnalitikaXml {

    private long id;

    private long br_stavke;

    private String duznik;

    private String svrha_placanja;

    private String poverilac_primalac;

    private String datum_prijema;

    private String datum_valute;

    private RacuniLica racun_duznika;

    private int model_zaduzenja;

    private String poziv_na_brZ; //zaduzenja

    private String racun_poverioca; // racun banke

    private int model_odobrenja;

    private String poziv_na_brO; //odobrenja

    private boolean hitno;

    private double iznos;

    private int tip_greske;

    private String status;

    private Valute valuta;

    private VrstePlacanja vrstaPlacanja;

    private DnevnoStanjeRacuna dnevnoStanjeRacuna;

    private NaseljenoMesto naseljenoMesto;

    public AnalitikaXml(AnalitikaIzvoda analitikaIzvoda) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.id = analitikaIzvoda.getId();
        this.br_stavke = analitikaIzvoda.getBr_stavke();
        this.datum_prijema = format.format(analitikaIzvoda.getDatum_prijema());
        this.datum_valute = format.format(analitikaIzvoda.getDatum_valute());
        this.dnevnoStanjeRacuna = analitikaIzvoda.getDnevnoStanjeRacuna();
        this.duznik = analitikaIzvoda.getDuznik();
        this.hitno = analitikaIzvoda.isHitno();
        this.iznos = analitikaIzvoda.getIznos();
        this.model_odobrenja = analitikaIzvoda.getModel_odobrenja();
        this.model_zaduzenja = analitikaIzvoda.getModel_zaduzenja();
        this.naseljenoMesto = analitikaIzvoda.getNaseljenoMesto();
        this.poverilac_primalac = analitikaIzvoda.getPoverilac_primalac();
        this.poziv_na_brO = analitikaIzvoda.getPoziv_na_brO();
        this.poziv_na_brZ = analitikaIzvoda.getPoziv_na_brZ();
        this.racun_duznika = analitikaIzvoda.getRacun_duznika();
        this.racun_poverioca = analitikaIzvoda.getRacun_poverioca();
        this.status = analitikaIzvoda.getStatus();
        this.svrha_placanja = analitikaIzvoda.getSvrha_placanja();
        this.tip_greske = analitikaIzvoda.getTip_greske();
        this.vrstaPlacanja = analitikaIzvoda.getVrstaPlacanja();
        this.valuta = analitikaIzvoda.getValuta();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBr_stavke() {
        return br_stavke;
    }

    public void setBr_stavke(long br_stavke) {
        this.br_stavke = br_stavke;
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

    public String getDatum_prijema() {
        return datum_prijema;
    }

    public void setDatum_prijema(String datum_prijema) {
        this.datum_prijema = datum_prijema;
    }

    public String getDatum_valute() {
        return datum_valute;
    }

    public void setDatum_valute(String datum_valute) {
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

    public void setModel_odobrenja(int model_odobrenja) {
        this.model_odobrenja = model_odobrenja;
    }

    public String getPoziv_na_brO() {
        return poziv_na_brO;
    }

    public void setPoziv_na_brO(String poziv_na_brO) {
        this.poziv_na_brO = poziv_na_brO;
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

    public Valute getValuta() {
        return valuta;
    }

    public void setValuta(Valute valuta) {
        this.valuta = valuta;
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
}
