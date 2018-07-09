package poslovnaBanka.valute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ValuteController {


    @Autowired
    private ValuteService valuteService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/valute",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<Valute>> getAll(){

        List<Valute> valute = valuteService.findAll();

        return new ResponseEntity<List<Valute>>(valute, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/valute/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Valute> getValuta(@PathVariable("id") long id) {
        Valute valute = this.valuteService.findOne(id);
        if(valute == null){
            return new ResponseEntity<Valute>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Valute>(valute, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/valute",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Valute> insertValuta(@RequestBody Valute valute) throws Exception{
        Valute createdValuta  = this.valuteService.create(valute);

        this.valuteService.update(createdValuta);
        return new ResponseEntity<Valute>(createdValuta, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/valute/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Valute> updateValuta(@PathVariable("id") long id, @RequestBody Valute valuta) throws Exception{
        Valute valute = this.valuteService.findOne(id);

        if(valute == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Valute updateValute = this.valuteService.update(valuta);
        if (updateValute == null) {
            return new ResponseEntity<Valute>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateValute, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/valute/{id}"
    )
    public ResponseEntity<Valute> deleteValuta(@PathVariable("id") long id){
        this.valuteService.delete(id);
        return new ResponseEntity<Valute>(HttpStatus.NO_CONTENT);
    }
}
