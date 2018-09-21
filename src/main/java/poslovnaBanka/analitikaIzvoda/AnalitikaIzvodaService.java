package poslovnaBanka.analitikaIzvoda;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AnalitikaIzvodaService {
    List<AnalitikaIzvoda> findAll();
    AnalitikaIzvoda create(AnalitikaIzvoda analitikaIzvoda);
    AnalitikaIzvoda exportUplata(AnalitikaIzvoda analitikaIzvoda) throws IOException;
    AnalitikaIzvoda exportIsplata(AnalitikaIzvoda analitikaIzvoda) throws IOException;
    AnalitikaIzvoda exportPrenos(AnalitikaIzvoda analitikaIzvoda) throws IOException;
    AnalitikaIzvoda importUplata(MultipartFile file);
    AnalitikaIzvoda importIsplata(MultipartFile file);
}
