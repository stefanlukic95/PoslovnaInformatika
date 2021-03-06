package poslovnaBanka.kurs;

import poslovnaBanka.valute.Valute;

import javax.persistence.*;

@Entity
@Table(name = "KursValuti")
public class KursValuti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int redni_br;
    private double kupovni;
    private double srednji;
    private double prodajni;

    @ManyToOne(fetch = FetchType.EAGER)
    private KursnaLista kursnaLista;

    @ManyToOne(fetch = FetchType.EAGER)
    private Valute valute;

    public KursValuti(){

    }

    public KursValuti(int redni_br, double kupovni, double srednji, double prodajni, KursnaLista kursnaLista, Valute valute) {
        this.redni_br = redni_br;
        this.kupovni = kupovni;
        this.srednji = srednji;
        this.prodajni = prodajni;
        this.kursnaLista = kursnaLista;
        this.valute = valute;
    }

    public KursnaLista getKursnaLista() {
        return kursnaLista;
    }

    public void setKursnaLista(KursnaLista kursnaLista) {
        this.kursnaLista = kursnaLista;
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


    public int getRedni_br() {
        return redni_br;
    }

    public void setRedni_br(int redni_br) {
        this.redni_br = redni_br;
    }

    public double getKupovni() {
        return kupovni;
    }

    public void setKupovni(double kupovni) {
        this.kupovni = kupovni;
    }

    public double getSrednji() {
        return srednji;
    }

    public void setSrednji(double srednji) {
        this.srednji = srednji;
    }

    public double getProdajni() {
        return prodajni;
    }

    public void setProdajni(double prodajni) {
        this.prodajni = prodajni;
    }
}
