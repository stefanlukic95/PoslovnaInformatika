package poslovnaBanka.kurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
@CrossOrigin("*")
public class KursValutiController {


    @Autowired
    private KursValutiService kursValutiService;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/kurs-valuti",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<KursValuti>> getAll(){

        List<KursValuti> kursvaluti = kursValutiService.findAll();

        return new ResponseEntity<List<KursValuti>>(kursvaluti, HttpStatus.OK);
    }
}
