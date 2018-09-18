package poslovnaBanka.racuni;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
@Transactional
public class ClearingServiceImpl implements ClearingService {

    @Autowired
    private ClearingRepository clearingRepository;

    @Override
    public void increaseSum(Clearing clearing,double iznos) {
        clearing.setUkupan_iznos(clearing.getUkupan_iznos()+iznos);
        clearingRepository.save(clearing);
    }

    @Override
    public Clearing exportClearing(Clearing clearing) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("export//clearing//clearing" + clearing.getId() + ".xml"), clearing);
        File file = new File("export//clearing//clearing" + clearing.getId() + ".xml");
        assertNotNull(file);
        return null;
    }

    @Override
    public Clearing save(Clearing clearing) {
        return clearingRepository.save(clearing);
    }
}
