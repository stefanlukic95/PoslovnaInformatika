package poslovnaBanka.klijent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class FizickoLiceServiceImpl implements FizickoLiceService {
    @Autowired
    private FizickoLiceRepository fizickoLiceRepository;

    @Override
    public FizickoLice addFizickoLice(FizickoLice fizickoLice) {
        fizickoLice.setDatum_registracije(new Date());
        return fizickoLiceRepository.save(fizickoLice);
    }
}
