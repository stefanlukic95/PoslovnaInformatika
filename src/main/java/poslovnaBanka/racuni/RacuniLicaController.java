package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import poslovnaBanka.racuni.RacuniLica;
import poslovnaBanka.racuni.RacuniLicaService;

import java.awt.*;
import java.util.List;



@RestController
@RequestMapping
@CrossOrigin("*")
public class RacuniLicaController {

    @Autowired
    private RacuniLicaService racuniLicaService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/racuni",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<RacuniLica>> getAll(){

        List<RacuniLica> racun = racuniLicaService.findAll();

        return new ResponseEntity<List<RacuniLica>>(racun,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/racuni/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RacuniLica> getRacunLica(@PathVariable("id") long id) {
        RacuniLica racun = this.racuniLicaService.findOne(id);
        if(racun == null){
            return new ResponseEntity<RacuniLica>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RacuniLica>(racun, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/racuni",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RacuniLica> insertRacunLica(@RequestBody RacuniLica racun) throws Exception{
        RacuniLica createdRacun  = this.racuniLicaService.create(racun);

        return new ResponseEntity<RacuniLica>(createdRacun, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/racuni/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RacuniLica> updateRacunLica(@PathVariable("id") long id, @RequestBody RacuniLica racun) throws Exception{
        RacuniLica racuni = this.racuniLicaService.findOne(id);

        if(racuni == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        RacuniLica updateRacun = this.racuniLicaService.update(racun);
        if (updateRacun == null) {
            return new ResponseEntity<RacuniLica>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateRacun, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/racuni/{id}"
    )
    public ResponseEntity<RacuniLica> deleteRacunLica(@PathVariable("id") long id){
        this.racuniLicaService.delete(id);
        return new ResponseEntity<RacuniLica>(HttpStatus.NO_CONTENT);
    }

}