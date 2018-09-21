package poslovnaBanka.analitikaIzvoda;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface AnalitikaIzvodaService {
    List<AnalitikaIzvoda> findAll();
    AnalitikaIzvoda create(AnalitikaIzvoda analitikaIzvoda);
    AnalitikaIzvoda exportUplata(AnalitikaIzvoda analitikaIzvoda) throws IOException;
    AnalitikaIzvoda exportIsplata(AnalitikaIzvoda analitikaIzvoda) throws IOException;
<<<<<<< HEAD
    AnalitikaIzvoda exportPrenos(AnalitikaIzvoda analitikaIzvoda) throws IOException;
    AnalitikaIzvoda importUplata(MultipartFile file);
    AnalitikaIzvoda importIsplata(MultipartFile file);
=======
    AnalitikaIzvoda importUplata(MultipartFile file) throws IOException, ParseException;
    AnalitikaIzvoda importIsplata(MultipartFile file) throws IOException, ParseException;
>>>>>>> 6983c2dc07940efbcd63b1e7d217ea23e21e9ea3
}
