package poslovnaBanka.naseljenoMesto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poslovnaBanka.drzava.Drzava;
import poslovnaBanka.drzava.DrzavaService;

import java.util.List;
@RestController
@RequestMapping
@CrossOrigin("*")
public class NaseljenoMestoController {


    @Autowired
    private NaseljenoMestoService naseljenoMestoService;

    @Autowired
    private DrzavaService drzavaService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/naseljenamesta",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<NaseljenoMesto>> getAll(){

        List<NaseljenoMesto> naseljenoMesto = naseljenoMestoService.findAll();

        return new ResponseEntity<List<NaseljenoMesto>>(naseljenoMesto, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/naseljenamesta/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NaseljenoMesto> getNaseljenoMesto(@PathVariable("id") long id) {
        NaseljenoMesto naseljenoMesto = this.naseljenoMestoService.findOne(id);
        if(naseljenoMesto == null){
            return new ResponseEntity<NaseljenoMesto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<NaseljenoMesto>(naseljenoMesto, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/naseljenamesta/drzave/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NaseljenoMesto> insertNaseljenoMesto(@RequestBody NaseljenoMesto naseljenoMesto, @PathVariable ("id") long id) throws Exception{
        NaseljenoMesto createdNasm  = this.naseljenoMestoService.create(naseljenoMesto);

        Drzava drzava = drzavaService.findOne(id);
        drzava.setNaseljenoMesto(createdNasm);
        drzavaService.update(drzava);
        return new ResponseEntity<NaseljenoMesto>(createdNasm, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/naseljenamesta/drzave/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NaseljenoMesto> updateNaseljenoMesto(@PathVariable("id") long id, @RequestBody NaseljenoMesto nasm) throws Exception{
        NaseljenoMesto naseljenoMesto = this.naseljenoMestoService.findOne(id);

        if(naseljenoMesto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        NaseljenoMesto updateNasm = this.naseljenoMestoService.update(nasm);
        if (updateNasm == null) {
            return new ResponseEntity<NaseljenoMesto>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(updateNasm, HttpStatus.OK);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/naseljenamesta/drzave/{id}"
    )
    public ResponseEntity<NaseljenoMesto> deleteNaseljenoMesto(@PathVariable("id") long id){
        this.naseljenoMestoService.delete(id);
        return new ResponseEntity<NaseljenoMesto>(HttpStatus.NO_CONTENT);
    }
}
