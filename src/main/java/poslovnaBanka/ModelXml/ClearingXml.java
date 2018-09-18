package poslovnaBanka.ModelXml;

import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;
import poslovnaBanka.racuni.Clearing;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "clearing")
public class ClearingXml {

    private long id;
    private String id_poruke;
    private double ukupan_iznos;
    private String datum;
    private List<AnalitikaXml> placanja;

    public ClearingXml(Clearing clearing) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.id = clearing.getId();
        this.id_poruke = clearing.getId_poruke();
        this.ukupan_iznos = clearing.getUkupan_iznos();
        this.datum = format.format(clearing.getDatum());
        List<AnalitikaXml> analitikaXmls = new ArrayList<AnalitikaXml>();
        for(AnalitikaIzvoda a : clearing.getPojedinacnoPlacanje()) {
            analitikaXmls.add(new AnalitikaXml(a));
        }
        this.placanja = analitikaXmls;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_poruke() {
        return id_poruke;
    }

    public void setId_poruke(String id_poruke) {
        this.id_poruke = id_poruke;
    }

    public double getUkupan_iznos() {
        return ukupan_iznos;
    }

    public void setUkupan_iznos(double ukupan_iznos) {
        this.ukupan_iznos = ukupan_iznos;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @XmlElementWrapper
    @XmlElement(name="placanje")
    public List<AnalitikaXml> getPojedinacnoPlacanje() {
        return placanja;
    }

    public void setPojedinacnoPlacanje(List<AnalitikaXml> pojedinacnoPlacanje) {
        this.placanja = pojedinacnoPlacanje;
    }
}
