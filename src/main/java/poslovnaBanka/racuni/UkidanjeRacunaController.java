package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UkidanjeRacunaController {

    @Autowired
    private DnevnoStanjeRacunaService dnevnoStanjeRacunaService;

    @Autowired
    private UkidanjeRacunaService ukidanjeRacunaService;


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/ukidanjeRacuna",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UkidanjeRacuna> createUkidanjeRacuna(@RequestBody UkidanjeRacuna racun, @PathVariable("id") long id) throws Exception{

        UkidanjeRacuna racuncreate  = this.ukidanjeRacunaService.create(racun);

        return new ResponseEntity<UkidanjeRacuna>(racuncreate, HttpStatus.CREATED);
    }
}
