package poslovnaBanka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poslovnaBanka.banka.Banka;
import poslovnaBanka.banka.BankaRepository;
import poslovnaBanka.drzava.Drzava;
import poslovnaBanka.drzava.DrzavaRepository;
import poslovnaBanka.klijent.FizickoLice;
import poslovnaBanka.klijent.FizickoLiceRepository;
import poslovnaBanka.klijent.PravnoLice;
import poslovnaBanka.klijent.PravnoLiceRepository;
import poslovnaBanka.kurs.KursValuti;
import poslovnaBanka.kurs.KursValutiRepository;
import poslovnaBanka.kurs.KursnaLista;
import poslovnaBanka.kurs.KursnaListaRepository;
import poslovnaBanka.naseljenoMesto.NaseljenoMesto;
import poslovnaBanka.naseljenoMesto.NaseljenoMestoRepository;
import poslovnaBanka.racuni.RacuniLica;
import poslovnaBanka.racuni.RacuniLicaRepository;
import poslovnaBanka.valute.Valute;
import poslovnaBanka.valute.ValuteRepository;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestData {

    @Autowired
    private ValuteRepository valuteRepository;

    @Autowired
    private RacuniLicaRepository racuniLicaRepository;

    @Autowired
    private NaseljenoMestoRepository naseljenoMestoRepository;

    @Autowired
    private DrzavaRepository drzavaRepository;

    @Autowired
    private FizickoLiceRepository fizickoLiceRepository;

    @Autowired
    private PravnoLiceRepository pravnoLiceRepository;

    @Autowired
    private BankaRepository bankaRepository;

    @Autowired
    private KursnaListaRepository kursnaListaRepository;

    @Autowired
    private KursValutiRepository kursValutiRepository;

    @PostConstruct
    public void podaci(){

        //DRZAVE
        Drzava drzava1 = new Drzava("SRB","Srbija");
        drzavaRepository.save(drzava1);
        Drzava drzava2 = new Drzava("ESP","Spanija");
        drzavaRepository.save(drzava2);
        Drzava drzava3 = new Drzava("HRV","Hrvatska");
        drzavaRepository.save(drzava3);
        Drzava drzava4 = new Drzava("MKD","Makedonija");
        drzavaRepository.save(drzava4);

        //NASELJENA MESTA
        NaseljenoMesto nasm1 = new NaseljenoMesto(123,"Novi Sad","21000", drzava1);
        naseljenoMestoRepository.save(nasm1);
        NaseljenoMesto nasm2 = new NaseljenoMesto(124,"Beograd","11000", drzava1);
        naseljenoMestoRepository.save(nasm2);
        NaseljenoMesto nasm3 = new NaseljenoMesto(125,"Becej","21200", drzava3);
        naseljenoMestoRepository.save(nasm3);
        NaseljenoMesto nasm4 = new NaseljenoMesto(126,"Skoplje","89000", drzava4);
        naseljenoMestoRepository.save(nasm4);

        //VALUTE
        Valute valuta1 =  new Valute(321,"evr","evro",false,drzava3);
        valuteRepository.save(valuta1);
        Valute valuta2 =  new Valute(3255551,"dol","dolar",false,drzava2);
        valuteRepository.save(valuta2);
        Valute valuta3 =  new Valute(9891,"din","dinar",true,drzava1);
        valuteRepository.save(valuta3);


        //BANKA
        Banka banka = new Banka("234234","4325","Banka intesa","Ulica 1","banka@gmail.com","web1","021-42343-5345","011-324-4324",true,"34244234","64364-754754-8434763");
        bankaRepository.save(banka);

        //KLIJENTI
        String datum1 = "2017-05-04";
        String datum2 = "2018-03-03";
        String datum3 = "2016-03-02";
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD");

        try {
            Date date = format.parse(datum1);
            Date date2 = format.parse(datum2);
            Date date3 = format.parse(datum3);

            FizickoLice fizl = new FizickoLice("Pera Peric", "pera@gmail.com","Ulica dobra jako 12","021-876-878",date,"0870069659");
            fizickoLiceRepository.save(fizl);
            FizickoLice fiz2 = new FizickoLice("Milan Milic", "milan@gmail.com","Ulica dobra jos vise 13","021-076-878",date2,"083299659");
            fizickoLiceRepository.save(fiz2);

            PravnoLice prav1 =  new PravnoLice("Mirko Mirkovic","mirko@gmail.com","ulica obicna 1","021-4324-5435",date,"1244" );
            pravnoLiceRepository.save(prav1);
            PravnoLice prav2 =  new PravnoLice("Miroslav Ilic","miroslav@gmail.com","ulica obicna 344","021-87438-546",date2,"5654" );
            pravnoLiceRepository.save(prav1);


            //RACUNI
            RacuniLica racun1 =  new RacuniLica("0327832-43432-43",date2,true,valuta1,banka);
            racuniLicaRepository.save(racun1);
            RacuniLica racun2 =  new RacuniLica("765432-768682-9797",date,true,valuta2,banka);
            racuniLicaRepository.save(racun2);

            //KURSNA LISTA
            KursnaLista kursl1 =  new KursnaLista(date3,"1234",date2,banka);
            kursnaListaRepository.save(kursl1);
            KursnaLista kursl2 =  new KursnaLista(date,"0098",date2,banka);
            kursnaListaRepository.save(kursl2);


            //KURS VALUTI
            KursValuti kursValuti1 =  new KursValuti(1,120,119,118,kursl2,valuta3);
            kursValutiRepository.save(kursValuti1);
            KursValuti kursValuti2 =  new KursValuti(2,123,121,117,kursl1,valuta1);
            kursValutiRepository.save(kursValuti2);

        } catch (ParseException e) {
            e.printStackTrace();
        }










    }

}
