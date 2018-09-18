package poslovnaBanka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;
import poslovnaBanka.analitikaIzvoda.AnalitikaIzvodaService;
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
import poslovnaBanka.racuni.*;
import poslovnaBanka.valute.Valute;
import poslovnaBanka.valute.ValuteRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @Autowired
    private VrstePlacanjaRepository vrstePlacanjaRepository;

    @Autowired
    private DnevnoStanjeRacunaRepository dnevnoStanjeRacunaRepository;

    @Autowired
    private ClearingRepository clearingRepository;

    @Autowired
    private RTGSService rtgsService;

    @Autowired
    private AnalitikaIzvodaService analitikaIzvodaService;

    @Autowired
    private ClearingService clearingService;


    @PostConstruct
    public void podaci() throws IOException {

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
        Clearing clearing = new Clearing();
        clearingRepository.save(clearing);
        banka.setAktivanClearing(clearing);
        bankaRepository.save(banka);
        Banka banka2 = new Banka("0009894234","9356655","Erste banka","Ulica 2","banka2@gmail.com","web1","021-09043-5095","011-8784-1010",true,"786364378","12321-546467-090989");
        bankaRepository.save(banka2);
        Clearing clearing2 = new Clearing();
        clearingRepository.save(clearing2);

        //KLIJENTI
        String datum1 = "2017-05-04";
        String datum2 = "2018-03-03";
        String datum3 = "2016-03-02";
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD");

        AnalitikaIzvoda analitikaIzvoda = new AnalitikaIzvoda();
        analitikaIzvoda.setBr_stavke(123);
        analitikaIzvoda.setDatum_prijema(new Date());
        analitikaIzvoda.setDuznik("duznik");
        analitikaIzvoda.setSvrha_placanja("svrha");
        analitikaIzvoda.setPoverilac_primalac("poverilac");
        analitikaIzvoda.setDatum_valute(new Date());
        analitikaIzvoda.setIznos(500);
        AnalitikaIzvoda analitika = analitikaIzvodaService.create(analitikaIzvoda);
        AnalitikaIzvoda analitikaIzvoda1 = new AnalitikaIzvoda();
        analitikaIzvoda1.setBr_stavke(12);
        analitikaIzvoda1.setDatum_prijema(new Date());
        analitikaIzvoda1.setDuznik("duznik");
        analitikaIzvoda1.setSvrha_placanja("svrha");
        analitikaIzvoda1.setPoverilac_primalac("poverilac");
        analitikaIzvoda1.setDatum_valute(new Date());
        analitikaIzvoda1.setIznos(800);
        AnalitikaIzvoda analitika1 = analitikaIzvodaService.create(analitikaIzvoda);
        RTGS rtgs = rtgsService.createRTGS(analitika);
        rtgsService.exportRTGS(rtgs);

        List<AnalitikaIzvoda> analitike = new ArrayList<AnalitikaIzvoda>();
        analitike.add(analitikaIzvoda);
        analitike.add(analitikaIzvoda1);
        clearing.setPojedinacnoPlacanje(analitike);
        clearingService.exportClearing(clearing);


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

            //DNEVNO STANJE RACUNA
            DnevnoStanjeRacuna dnevnoStanjeRacuna1 = new DnevnoStanjeRacuna(date2,123.2,130.1,140.4,137.5,racun2);
            dnevnoStanjeRacunaRepository.save(dnevnoStanjeRacuna1);
            DnevnoStanjeRacuna dnevnoStanjeRacuna2 = new DnevnoStanjeRacuna(date,183.2,190.1,1140.4,237.5,racun1);
            dnevnoStanjeRacunaRepository.save(dnevnoStanjeRacuna2);

        } catch (ParseException e) {
            e.printStackTrace();
        }


            //VRSTE PLACANJA
            VrstePlacanja vrstePlacanja1 =  new VrstePlacanja(123  ,"naziv1");
            vrstePlacanjaRepository.save(vrstePlacanja1);
            VrstePlacanja vrstePlacanja2 =  new VrstePlacanja(124  ,"naziv2");
            vrstePlacanjaRepository.save(vrstePlacanja2);










    }

}
