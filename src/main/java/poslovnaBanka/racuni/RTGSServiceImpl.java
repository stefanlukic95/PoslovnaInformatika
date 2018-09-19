package poslovnaBanka.racuni;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;

import java.io.File;
import java.io.IOException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Transactional
@Service
public class RTGSServiceImpl implements RTGSService {
    @Autowired
    private RTGSRepository rtgsRepository;

    @Override
    public RTGS createRTGS(AnalitikaIzvoda analitika) {
        RTGS rtgs = new RTGS();
        rtgs.setAnalitikaIzvoda(analitika);
        return rtgsRepository.save(rtgs);
    }

    @Override
    public RTGS exportRTGS(RTGS rtgs) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("export//rtgs//rtgs" + rtgs.getId() + ".xml"), rtgs);
        File file = new File("export//rtgs//rtgs" + rtgs.getId() + ".xml");
        assertNotNull(file);
        return rtgs;
    }
}
