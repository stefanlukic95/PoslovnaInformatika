package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        PravnoLice pravnoLice1 = pravnoLiceService.addPravnoLice(pravnoLice);
        return new ResponseEntity<PravnoLice>(pravnoLice1, HttpStatus.CREATED);

    }
}
