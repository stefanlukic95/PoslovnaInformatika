package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class RacunLicaController {

    @Autowired
    private RacuniLicaService racuniLicaService;

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/racuni",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<RacuniLica>> getAll(){
        List<RacuniLica> racun = racuniLicaService.findAll();

        return new ResponseEntity<List<RacuniLica>>(racun,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/racuni/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<RacuniLica> getRacun(@PathVariable("id") long id) {
        RacuniLica rac = this.racuniLicaService.findOne(id);
        if(rac == null){
            return new ResponseEntity<RacuniLica>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RacuniLica>(rac, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/racuni/klijentFizicko/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RacuniLica> insertRacunFizicko(@RequestBody RacuniLica racun, @PathVariable("id") long id) throws Exception{

        RacuniLica racuniLica  = this.racuniLicaService.createRacunFizicko(racun, id);

        return new ResponseEntity<RacuniLica>(racuniLica, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/racuni/klijentPravno/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RacuniLica> insertRacunPravno(@RequestBody RacuniLica racun, @PathVariable("id") long id) throws Exception{
        RacuniLica racuniLica  = this.racuniLicaService.createRacunPravno(racun, id);

        return new ResponseEntity<RacuniLica>(racuniLica, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/racuni/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RacuniLica> updateDrzave(@PathVariable("id") long id, @RequestBody RacuniLica racun) throws Exception{
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
    public ResponseEntity<RacuniLica> deleteRacun(@PathVariable("id") long id){
        this.racuniLicaService.delete(id);
        return new ResponseEntity<RacuniLica>(HttpStatus.NO_CONTENT);
    }


}
