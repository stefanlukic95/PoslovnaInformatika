package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class FizickoLiceServiceImpl implements FizickoLiceService {
    @Autowired
    private FizickoLiceRepository fizickoLiceRepository;

    @Override
    public FizickoLice add(FizickoLice fizickoLice) {
        fizickoLice.setDatum_registracije(new Date());
        return fizickoLiceRepository.save(fizickoLice);
    }

    @Override
    public List<FizickoLice> findAll() {
        return fizickoLiceRepository.findAll();
    }

    @Override
    public FizickoLice update(FizickoLice fizickoLice) {
        return fizickoLiceRepository.save(fizickoLice);
    }

    @Override
    public FizickoLice findOne(Long id) {
        return fizickoLiceRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        fizickoLiceRepository.delete(id);
    }
}
