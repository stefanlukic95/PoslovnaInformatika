package poslovnaBanka.analitikaIzvoda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class AnalitikaIzvodaController {

    @Autowired
    private AnalitikaIzvodaService analitikaIzvodaService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/analitika",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<AnalitikaIzvoda>> getAnalitike() {
        return new ResponseEntity<List<AnalitikaIzvoda>>(analitikaIzvodaService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/analitika",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AnalitikaIzvoda> createAnalitika(@RequestBody AnalitikaIzvoda analitikaIzvoda) {
        return new ResponseEntity<AnalitikaIzvoda>(analitikaIzvodaService.create(analitikaIzvoda), HttpStatus.OK);
    }

    @PostMapping(value="/analitikaFile")
    public ResponseEntity<AnalitikaIzvoda> importAnalitika(@RequestParam("file") MultipartFile file) {
        System.out.println("FILE NAME: " + file.getOriginalFilename());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
