package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;


@RestController
@CrossOrigin("*")
public class FizickoLiceController {

    @Autowired
    private FizickoLiceService fizickoLiceService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/fizickoLice",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FizickoLice> addFizickoLice(@RequestBody FizickoLice fizickoLice) {

        FizickoLice fizickoLice1 = fizickoLiceService.add(fizickoLice);
        return new ResponseEntity<FizickoLice>(fizickoLice1, HttpStatus.CREATED);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/fizickaLica",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FizickoLice>> getFizickaLica() {
        List<FizickoLice> fizickaLica = fizickoLiceService.findAll();
        return new ResponseEntity<List<FizickoLice>>(fizickaLica, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/fizickoLice/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FizickoLice> getFizickoLice(@PathVariable Long id) {
        FizickoLice fizickoLice = fizickoLiceService.findOne(id);
        return new ResponseEntity<FizickoLice>(fizickoLice, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/fizickoLice",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FizickoLice> updateFizickoLice(@RequestBody FizickoLice fizickoLice) {
        return new ResponseEntity<FizickoLice>(fizickoLiceService.update(fizickoLice), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/fizickoLice/{id}"
    )
    public ResponseEntity<FizickoLice> deleteFizickoLice(@PathVariable Long id) {
        fizickoLiceService.delete(id);
        return new ResponseEntity<FizickoLice>(HttpStatus.OK);
    }
}
