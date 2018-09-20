package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import poslovnaBanka.banka.BankaService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ClearingController {

    @Autowired
    private BankaService bankaService;

    @Autowired
    private ClearingService clearingService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/obradiClearing",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> obradiClearing() throws IOException {
        Clearing clearing = bankaService.getBanka().getAktivanClearing();
        clearing.setDatum(new Date());
        clearingService.exportClearing(clearing);
        Clearing clearing1 = new Clearing();
        bankaService.getBanka().setAktivanClearing(clearing1);
        bankaService.save(bankaService.getBanka());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/obradiClearing",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getObradjeni() {
        List<Clearing> obradjeni = clearingService.getObradjeni();
        return new ResponseEntity<List<Clearing>>(obradjeni, HttpStatus.OK);
    }
}
