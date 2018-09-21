package poslovnaBanka.analitikaIzvoda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poslovnaBanka.banka.BankaService;
import poslovnaBanka.racuni.*;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class AnalitikaIzvodaController {

    @Autowired
    private AnalitikaIzvodaService analitikaIzvodaService;

    @Autowired
    private ClearingService clearingService;

    @Autowired
    private RTGSService rtgsService;

    @Autowired
    private BankaService bankaService;

    @Autowired
    private RacuniLicaService racuniLicaService;

    @Autowired
    private DnevnoStanjeRacunaService dnevnoStanjeRacunaService;


    @Autowired
    private UkidanjeRacunaService ukidanjeRacunaService;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/analitika",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<AnalitikaIzvoda>> getAnalitike() {
        return new ResponseEntity<List<AnalitikaIzvoda>>(analitikaIzvodaService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            method =  RequestMethod.POST,
            value = "/analitikaPrenos/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AnalitikaIzvoda> createAnalitikaPrenos(@PathVariable ("id") long id, @RequestBody AnalitikaIzvoda analitikaIzvoda) throws IOException{
        RacuniLica racunZaPrenos = analitikaIzvoda.getRacun_duznika();
        DnevnoStanjeRacuna poslednje = dnevnoStanjeRacunaService.getLast(racunZaPrenos);
        analitikaIzvoda.setDnevnoStanjeRacuna(poslednje);
        RacuniLica racunGdeSePrenosi = racuniLicaService.findOne(id);
        DnevnoStanjeRacuna poslednje2 = dnevnoStanjeRacunaService.getLast(racunGdeSePrenosi);
        DnevnoStanjeRacuna novoStanje = new DnevnoStanjeRacuna(new Date(), poslednje2.getNovo_stanje(), poslednje.getNovo_stanje(),0,poslednje2.getNovo_stanje() + poslednje.getNovo_stanje(),racunGdeSePrenosi);
        DnevnoStanjeRacuna dsr =  dnevnoStanjeRacunaService.create(novoStanje);
        analitikaIzvoda.setDnevnoStanjeRacuna(dsr);
        AnalitikaIzvoda analitika = analitikaIzvodaService.create(analitikaIzvoda);
        analitikaIzvodaService.exportPrenos(analitikaIzvoda);
        UkidanjeRacuna ukidanje = new UkidanjeRacuna(new Date(), racunGdeSePrenosi.getBr_racuna() );
        ukidanjeRacunaService.create(ukidanje);


        return new ResponseEntity<AnalitikaIzvoda>(analitika, HttpStatus.CREATED);
    }
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/analitikaUplata",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AnalitikaIzvoda> createAnalitikaUplata(@RequestBody AnalitikaIzvoda analitikaIzvoda) throws IOException {

        RacuniLica racun = analitikaIzvoda.getRacun_duznika();
        DnevnoStanjeRacuna pret = dnevnoStanjeRacunaService.getLast(racun);
        DnevnoStanjeRacuna novo = new DnevnoStanjeRacuna(new Date(), pret.getNovo_stanje(), analitikaIzvoda.getIznos(), 0, pret.getNovo_stanje() + analitikaIzvoda.getIznos(), racun);
        DnevnoStanjeRacuna d = dnevnoStanjeRacunaService.create(novo);
        analitikaIzvoda.setDnevnoStanjeRacuna(d);
        AnalitikaIzvoda analitika = analitikaIzvodaService.create(analitikaIzvoda);
        analitikaIzvodaService.exportUplata(analitikaIzvoda);
        if((analitika.getIznos() >= 250000 || analitika.isHitno()) && racun.getBanka().getId() == bankaService.getBanka().getId()) {
            rtgsService.createRTGS(analitika);
        } else {
            Clearing clearing = bankaService.getBanka().getAktivanClearing();
            clearing.setUkupan_iznos(clearing.getUkupan_iznos() + analitika.getIznos());
            List<AnalitikaIzvoda> analitike = clearing.getPojedinacnoPlacanje();
            analitike.add(analitika);
            clearing.setPojedinacnoPlacanje(analitike);
            clearingService.save(clearing);
        }

        return new ResponseEntity<AnalitikaIzvoda>(analitika, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/analitikaIsplata",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AnalitikaIzvoda> createAnalitikaIsplata(@RequestBody AnalitikaIzvoda analitikaIzvoda) throws IOException {

        RacuniLica racun = analitikaIzvoda.getRacun_duznika();
        DnevnoStanjeRacuna pret = dnevnoStanjeRacunaService.getLast(racun);
        DnevnoStanjeRacuna novo = new DnevnoStanjeRacuna(new Date(), pret.getNovo_stanje(), 0, analitikaIzvoda.getIznos(), pret.getNovo_stanje() - analitikaIzvoda.getIznos(), racun);
        DnevnoStanjeRacuna d = dnevnoStanjeRacunaService.create(novo);
        analitikaIzvoda.setDnevnoStanjeRacuna(d);
        AnalitikaIzvoda analitika = analitikaIzvodaService.create(analitikaIzvoda);
        analitikaIzvodaService.exportIsplata(analitikaIzvoda);
        if((analitika.getIznos() >= 250000 || analitika.isHitno()) && racun.getBanka().getId() == bankaService.getBanka().getId()) {
            rtgsService.createRTGS(analitika);
        } else {
            Clearing clearing = bankaService.getBanka().getAktivanClearing();
            clearing.setUkupan_iznos(clearing.getUkupan_iznos() + analitika.getIznos());
            List<AnalitikaIzvoda> analitike = clearing.getPojedinacnoPlacanje();
            analitike.add(analitika);
            clearing.setPojedinacnoPlacanje(analitike);
            clearingService.save(clearing);
        }

        return new ResponseEntity<AnalitikaIzvoda>(analitika, HttpStatus.OK);
    }

    @PostMapping(value="/loadAnalitikaIsplata")
    public ResponseEntity<?> loadAnalitikaIsplata(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        System.out.println("FILE NAME: " + file.getOriginalFilename());
        AnalitikaIzvoda analitikaIzvoda = analitikaIzvodaService.importIsplata(file);
        RacuniLica racun = analitikaIzvoda.getRacun_duznika();
        DnevnoStanjeRacuna pret = dnevnoStanjeRacunaService.getLast(racun);
        DnevnoStanjeRacuna novo = new DnevnoStanjeRacuna(new Date(), pret.getNovo_stanje(), 0, analitikaIzvoda.getIznos(), pret.getNovo_stanje() - analitikaIzvoda.getIznos(), racun);
        DnevnoStanjeRacuna d = dnevnoStanjeRacunaService.create(novo);
        analitikaIzvoda.setDnevnoStanjeRacuna(d);
        AnalitikaIzvoda analitika = analitikaIzvodaService.create(analitikaIzvoda);
        System.out.println(analitika.getId());
        analitikaIzvodaService.exportIsplata(analitikaIzvoda);
        if((analitika.getIznos() >= 250000 || analitika.isHitno()) && racun.getBanka().getId() == bankaService.getBanka().getId()) {
            rtgsService.createRTGS(analitika);
        } else {
            Clearing clearing = bankaService.getBanka().getAktivanClearing();
            clearing.setUkupan_iznos(clearing.getUkupan_iznos() + analitika.getIznos());
            List<AnalitikaIzvoda> analitike = clearing.getPojedinacnoPlacanje();
            analitike.add(analitika);
            clearing.setPojedinacnoPlacanje(analitike);
            clearingService.save(clearing);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/loadAnalitikaUplata")
    public ResponseEntity<?> loadAnalitikaUplata(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        System.out.println("FILE NAME: " + file.getOriginalFilename());
        AnalitikaIzvoda analitikaIzvoda = analitikaIzvodaService.importUplata(file);

        RacuniLica racun = analitikaIzvoda.getRacun_duznika();
        DnevnoStanjeRacuna pret = dnevnoStanjeRacunaService.getLast(racun);
        DnevnoStanjeRacuna novo = new DnevnoStanjeRacuna(new Date(), pret.getNovo_stanje(), analitikaIzvoda.getIznos(), 0, pret.getNovo_stanje() + analitikaIzvoda.getIznos(), racun);
        DnevnoStanjeRacuna d = dnevnoStanjeRacunaService.create(novo);
        analitikaIzvoda.setDnevnoStanjeRacuna(d);
        AnalitikaIzvoda analitika = analitikaIzvodaService.create(analitikaIzvoda);
        analitikaIzvodaService.exportUplata(analitikaIzvoda);
        if((analitika.getIznos() >= 250000 || analitika.isHitno()) && racun.getBanka().getId() == bankaService.getBanka().getId()) {
            rtgsService.createRTGS(analitika);
        } else {
            Clearing clearing = bankaService.getBanka().getAktivanClearing();
            clearing.setUkupan_iznos(clearing.getUkupan_iznos() + analitika.getIznos());
            List<AnalitikaIzvoda> analitike = clearing.getPojedinacnoPlacanje();
            analitike.add(analitika);
            clearing.setPojedinacnoPlacanje(analitike);
            clearingService.save(clearing);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
