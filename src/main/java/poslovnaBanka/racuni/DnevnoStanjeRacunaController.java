package poslovnaBanka.racuni;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping
@RestController
@CrossOrigin("*")
public class DnevnoStanjeRacunaController {


    @Autowired
    private DnevnoStanjeRacunaService dnevnoStanjeRacunaService;

    @Autowired
    private RacuniLicaService racuniLicaService;

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
    public ResponseEntity<List<DnevnoStanjeRacuna>> getDnevnoStanjeRacuna(@PathVariable("id") long id) {
        RacuniLica racuniLica = racuniLicaService.findOne(id);
        List<DnevnoStanjeRacuna> stanja = dnevnoStanjeRacunaService.getByRacun(racuniLica);
        return new ResponseEntity<>(stanja, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/dnevnostanjeracuna/export/{id}/datumi",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<DnevnoStanjeRacuna>> exportStanja(@PathVariable("id") long id, @RequestParam("poc") String pocetak, @RequestParam("kraj") String kraj) throws ParseException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datumPocetak = format.parse(pocetak);
        Date datumKraj = format.parse(kraj);
        List<DnevnoStanjeRacuna> ret = dnevnoStanjeRacunaService.export(id, datumPocetak, datumKraj);
        return new ResponseEntity<>(ret, HttpStatus.OK);
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
