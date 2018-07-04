package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class PravnoLiceServiceImpl implements PravnoLiceService {
    @Autowired
    private PravnoLiceRepository pravnoLiceRepository;

    @Override
    public PravnoLice addPravnoLice(PravnoLice pravnoLice) {
        pravnoLice.setDatum_registracije(new Date());
        return pravnoLiceRepository.save(pravnoLice);
    }
}
