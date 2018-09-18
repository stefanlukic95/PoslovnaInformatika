package poslovnaBanka.analitikaIzvoda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import poslovnaBanka.banka.BankaService;
import poslovnaBanka.racuni.Clearing;
import poslovnaBanka.racuni.ClearingService;
import poslovnaBanka.racuni.RTGSService;

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

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/analitika",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<AnalitikaIzvoda>> getAnalitike() {
        return new ResponseEntity<List<AnalitikaIzvoda>>(analitikaIzvodaService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/analitika",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AnalitikaIzvoda> createAnalitika(@RequestBody AnalitikaIzvoda analitikaIzvoda) {
        AnalitikaIzvoda analitika = analitikaIzvodaService.create(analitikaIzvoda);
        if(analitika.getIznos() >= 250000 || analitika.isHitno()) {
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

    @PostMapping(value="/analitikaFile")
    public ResponseEntity<AnalitikaIzvoda> importAnalitika(@RequestParam("file") MultipartFile file) {
        System.out.println("FILE NAME: " + file.getOriginalFilename());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
