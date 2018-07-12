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
public class VrstePlacanjaController {

    @Autowired
    private VrstePlacanjaService vrstePlacanjaService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/vrsteplacanja",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<VrstePlacanja>> getAll(){

        List<VrstePlacanja> valute = vrstePlacanjaService.findAll();

        return new ResponseEntity<List<VrstePlacanja>>(valute, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value ="/vrsteplacanja/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<VrstePlacanja> getVrstePlacanja(@PathVariable("id") long id) {
        VrstePlacanja valute = this.vrstePlacanjaService.findOne(id);
        if(valute == null){
            return new ResponseEntity<VrstePlacanja>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VrstePlacanja>(valute, HttpStatus.OK);
    }

}
