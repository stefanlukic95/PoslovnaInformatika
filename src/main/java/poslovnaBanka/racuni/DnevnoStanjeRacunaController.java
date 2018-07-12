package poslovnaBanka.racuni;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@CrossOrigin("*")
public class DnevnoStanjeRacunaController {


    @Autowired
    private DnevnoStanjeRacunaService dnevnoStanjeRacunaService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/dnevnostanjeracuna",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<DnevnoStanjeRacuna>> getAll(){

        List<DnevnoStanjeRacuna> valute = dnevnoStanjeRacunaService.findAll();

        return new ResponseEntity<List<DnevnoStanjeRacuna>>(valute, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/dnevnostanjeracuna/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DnevnoStanjeRacuna> getDnevnoStanjeRacuna(@PathVariable("id") long id) {
        DnevnoStanjeRacuna valute = this.dnevnoStanjeRacunaService.findOne(id);
        if(valute == null){
            return new ResponseEntity<DnevnoStanjeRacuna>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DnevnoStanjeRacuna>(valute, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/dnevnostanjeracuna",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DnevnoStanjeRacuna> insertDnevnoStanjeRacuna(@RequestBody DnevnoStanjeRacuna valute) throws Exception{
        DnevnoStanjeRacuna createdValuta  = this.dnevnoStanjeRacunaService.create(valute);

        this.dnevnoStanjeRacunaService.update(createdValuta);
        return new ResponseEntity<DnevnoStanjeRacuna>(createdValuta, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/dnevnostanjeracuna/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DnevnoStanjeRacuna> updateDnevnoStanjeRacuna(@PathVariable("id") long id, @RequestBody DnevnoStanjeRacuna valuta) throws Exception{
        DnevnoStanjeRacuna valute = this.dnevnoStanjeRacunaService.findOne(id);

        if(valute == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DnevnoStanjeRacuna updateValute = this.dnevnoStanjeRacunaService.update(valuta);
        if (updateValute == null) {
            return new ResponseEntity<DnevnoStanjeRacuna>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateValute, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/dnevnostanjeracuna/{id}"
    )
    public ResponseEntity<DnevnoStanjeRacuna> deleteDnevnoStanjeRacuna(@PathVariable("id") long id){
        this.dnevnoStanjeRacunaService.delete(id);
        return new ResponseEntity<DnevnoStanjeRacuna>(HttpStatus.NO_CONTENT);
    }
}
