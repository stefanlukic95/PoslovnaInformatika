package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PravnoLiceController {
    @Autowired
    private PravnoLiceService pravnoLiceService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/pravnoLice",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PravnoLice> insertDrzava(@RequestBody PravnoLice pravnoLice) {

        PravnoLice pravnoLice1 = pravnoLiceService.add(pravnoLice);
        return new ResponseEntity<PravnoLice>(pravnoLice1, HttpStatus.CREATED);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/pravnaLica",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<PravnoLice>> getPravnaLica() {
        List<PravnoLice> pravnaLica = pravnoLiceService.findAll();
        return new ResponseEntity<List<PravnoLice>>(pravnaLica, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/pravnoLice/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PravnoLice> getPravnoLice(@PathVariable Long id) {
        PravnoLice pravnoLice = pravnoLiceService.findOne(id);
        return new ResponseEntity<PravnoLice>(pravnoLice, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/pravnoLice",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PravnoLice> updatePravnoLice(@RequestBody PravnoLice pravnoLice) {
        return new ResponseEntity<PravnoLice>(pravnoLiceService.update(pravnoLice), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/pravnoLice/{id}"
    )
    public ResponseEntity<PravnoLice> deletePravnoLice(@PathVariable Long id) {
        pravnoLiceService.delete(id);
        return new ResponseEntity<PravnoLice>(HttpStatus.OK);
    }
}
