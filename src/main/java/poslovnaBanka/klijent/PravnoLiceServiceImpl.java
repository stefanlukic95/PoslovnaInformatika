package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class PravnoLiceServiceImpl implements PravnoLiceService {
    @Autowired
    private PravnoLiceRepository pravnoLiceRepository;

    @Override
    public PravnoLice add(PravnoLice pravnoLice) {
        pravnoLice.setDatum_registracije(new Date());
        return pravnoLiceRepository.save(pravnoLice);
    }

    @Override
    public List<PravnoLice> findAll() {
        return pravnoLiceRepository.findAll();
    }

    @Override
    public PravnoLice update(PravnoLice pravnoLice) {
        return pravnoLiceRepository.save(pravnoLice);
    }

    @Override
    public PravnoLice findOne(Long id) {
        return pravnoLiceRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        pravnoLiceRepository.delete(id);
    }
}
