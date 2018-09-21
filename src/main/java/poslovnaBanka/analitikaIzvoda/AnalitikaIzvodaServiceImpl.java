package poslovnaBanka.analitikaIzvoda;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import poslovnaBanka.ModelXml.AnalitikaXml;
import poslovnaBanka.kurs.KursnaListaService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
@Transactional
public class AnalitikaIzvodaServiceImpl implements AnalitikaIzvodaService {

    @Autowired
    private AnalitikaIzvodaRepository analitikaIzvodaRepository;

    @Autowired
    private KursnaListaService kursnaListaService;

    @Override
    public List<AnalitikaIzvoda> findAll() {
        return analitikaIzvodaRepository.findAll();
    }

    @Override
    public AnalitikaIzvoda create(AnalitikaIzvoda analitikaIzvoda) {
        analitikaIzvoda.setDatum_valute(kursnaListaService.findLast().getDatum());
        return analitikaIzvodaRepository.save(analitikaIzvoda);
    }

    @Override
    public AnalitikaIzvoda exportUplata(AnalitikaIzvoda analitikaIzvoda) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        AnalitikaXml analitikaXml = new AnalitikaXml(analitikaIzvoda);
        xmlMapper.writeValue(new File("export//analitika//izvod_uplate" + analitikaXml.getId() + ".xml"), analitikaXml);
        File file = new File("export//analitika//izvod_uplate" + analitikaXml.getId() + ".xml");
        assertNotNull(file);
        return null;
    }

    @Override
    public AnalitikaIzvoda exportIsplata(AnalitikaIzvoda analitikaIzvoda) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        AnalitikaXml analitikaXml = new AnalitikaXml(analitikaIzvoda);
        xmlMapper.writeValue(new File("export//analitika//izvod_isplate" + analitikaXml.getId() + ".xml"), analitikaXml);
        File file = new File("export//analitika//izvod_isplate" + analitikaXml.getId() + ".xml");
        assertNotNull(file);
        return null;
    }

    @Override
    public AnalitikaIzvoda exportPrenos(AnalitikaIzvoda analitikaIzvoda) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        AnalitikaXml analitikaXml = new AnalitikaXml(analitikaIzvoda);
        xmlMapper.writeValue(new File("export//analitika//izvod prenosa" + analitikaXml.getId() + ".xml"), analitikaXml);
        File file = new File("export//analitika//izvod prenosa" + analitikaXml.getId() + ".xml");
        assertNotNull(file);
        return null;
    }


    @Override
    public AnalitikaIzvoda importUplata(MultipartFile file) {
        return null;
    }

    @Override
    public AnalitikaIzvoda importIsplata(MultipartFile file) {
        return null;
    }


}
