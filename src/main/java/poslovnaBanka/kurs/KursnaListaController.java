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
public class KursnaListaController {

    @Autowired
    private KursnaListaService kursnaListaService;


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/kursna-lista",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<List<KursnaLista>> getAll(){

        List<KursnaLista> kursnaLista = kursnaListaService.findAll();

        return new ResponseEntity<List<KursnaLista>>(kursnaLista, HttpStatus.OK);
    }
}
