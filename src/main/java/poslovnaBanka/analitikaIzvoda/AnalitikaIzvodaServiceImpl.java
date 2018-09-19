package poslovnaBanka.analitikaIzvoda;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poslovnaBanka.ModelXml.AnalitikaXml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
@Transactional
public class AnalitikaIzvodaServiceImpl implements AnalitikaIzvodaService {

    @Autowired
    private AnalitikaIzvodaRepository analitikaIzvodaRepository;

    @Override
    public List<AnalitikaIzvoda> findAll() {
        return analitikaIzvodaRepository.findAll();
    }

    @Override
    public AnalitikaIzvoda create(AnalitikaIzvoda analitikaIzvoda) {
        return analitikaIzvodaRepository.save(analitikaIzvoda);
    }

    @Override
    public AnalitikaIzvoda export(AnalitikaIzvoda analitikaIzvoda) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        AnalitikaXml analitikaXml = new AnalitikaXml(analitikaIzvoda);
        xmlMapper.writeValue(new File("export//analitika//analitika" + analitikaXml.getId() + ".xml"), analitikaXml);
        File file = new File("export//analitika//analitika" + analitikaXml.getId() + ".xml");
        assertNotNull(file);
        return null;
    }


}
