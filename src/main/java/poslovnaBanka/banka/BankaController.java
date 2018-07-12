package poslovnaBanka.banka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@CrossOrigin("*")
public class BankaController {

    @Autowired
    private BankaService bankaService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/banka",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<Banka>> getAll(){

        List<Banka> valute = bankaService.findAll();

        return new ResponseEntity<List<Banka>>(valute, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/banka/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Banka> getBanka(@PathVariable("id") long id) {
        Banka valute = this.bankaService.findOne(id);
        if(valute == null){
            return new ResponseEntity<Banka>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Banka>(valute, HttpStatus.OK);
    }

}
