package poslovnaBanka.drzava;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poslovnaBanka.naseljenoMesto.NaseljenoMesto;
import poslovnaBanka.naseljenoMesto.NaseljenoMestoService;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class DrzavaController {


    @Autowired
    private DrzavaService drzavaService;


    @Autowired
    private NaseljenoMestoService naseljenoMestoService;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/drzave",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<Drzava>> getAll(){

        List<Drzava> drzava = drzavaService.findAll();

        return new ResponseEntity<List<Drzava>>(drzava,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/drzave/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Drzava> getDrzava(@PathVariable("id") long id) {
        Drzava drzava = this.drzavaService.findOne(id);
        if(drzava == null){
            return new ResponseEntity<Drzava>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Drzava>(drzava, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/drzave",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Drzava> insertDrzava(@RequestBody Drzava drzava) throws Exception{
        Drzava createdDrzava  = this.drzavaService.create(drzava);

       /* NaseljenoMesto naseljenoMesto = naseljenoMestoService.findOne(id);

        naseljenoMesto.setDrzava(createdDrzava);
        naseljenoMestoService.update(naseljenoMesto);*/

        return new ResponseEntity<Drzava>(createdDrzava, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/drzave/naseljenamesta/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Drzava> updateDrzave(@PathVariable("id") long id, @RequestBody Drzava drzava) throws Exception{
        Drzava drzave = this.drzavaService.findOne(id);

        if(drzave == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Drzava updateDrzava = this.drzavaService.update(drzava);
        if (updateDrzava == null) {
            return new ResponseEntity<Drzava>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateDrzava, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/drzave/naseljenamesta/{id}"
    )
    public ResponseEntity<Drzava> deleteDrzava(@PathVariable("id") long id){
        this.drzavaService.delete(id);
        return new ResponseEntity<Drzava>(HttpStatus.NO_CONTENT);
    }
}
