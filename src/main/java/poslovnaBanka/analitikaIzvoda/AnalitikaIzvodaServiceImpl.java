package poslovnaBanka.analitikaIzvoda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
