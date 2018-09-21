package poslovnaBanka.analitikaIzvoda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import poslovnaBanka.ModelXml.AnalitikaXml;
import poslovnaBanka.kurs.KursnaListaService;

import java.io.*;
import java.nio.file.Files;
import java.text.ParseException;
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
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File("export//analitika//izvod_uplate" + analitikaXml.getId() + ".xml"), analitikaXml);
        File file = new File("export//analitika//izvod_uplate" + analitikaXml.getId() + ".xml");
        assertNotNull(file);
        return null;
    }

    @Override
    public AnalitikaIzvoda exportIsplata(AnalitikaIzvoda analitikaIzvoda) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        AnalitikaXml analitikaXml = new AnalitikaXml(analitikaIzvoda);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File("export//analitika//izvod_isplate" + analitikaXml.getId() + ".xml"), analitikaXml);
        File file = new File("export//analitika//izvod_isplate" + analitikaXml.getId() + ".xml");
        assertNotNull(file);
        return null;
    }

    @Override
    public AnalitikaIzvoda importUplata(MultipartFile file) throws IOException, ParseException {
        File f = null;
        f = Files.createTempFile("temp", file.getOriginalFilename()).toFile();
        file.transferTo(f);
        XmlMapper xmlMapper = new XmlMapper();
        String analitikaIsplata = inputStreamToString(new FileInputStream(f));
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        AnalitikaXml analitikaXml = xmlMapper.readValue(analitikaIsplata, AnalitikaXml.class);
        AnalitikaIzvoda analitika = new AnalitikaIzvoda(analitikaXml);
        return analitika;
    }

    @Override
    public AnalitikaIzvoda importIsplata(MultipartFile file) throws IOException, ParseException {
        File f = null;
        f = Files.createTempFile("temp", file.getOriginalFilename()).toFile();
        file.transferTo(f);
        XmlMapper xmlMapper = new XmlMapper();
        String analitikaIsplata = inputStreamToString(new FileInputStream(f));
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        AnalitikaXml analitikaXml = xmlMapper.readValue(analitikaIsplata, AnalitikaXml.class);
        AnalitikaIzvoda analitika = new AnalitikaIzvoda(analitikaXml);
        return analitika;
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }


}
