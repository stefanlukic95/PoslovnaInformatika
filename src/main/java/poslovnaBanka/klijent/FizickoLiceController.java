package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<FizickoLice> insertDrzava(@RequestBody FizickoLice fizickoLice) {

        FizickoLice fizickoLice1 = fizickoLiceService.addFizickoLice(fizickoLice);
        return new ResponseEntity<FizickoLice>(fizickoLice1, HttpStatus.CREATED);

    }
}
