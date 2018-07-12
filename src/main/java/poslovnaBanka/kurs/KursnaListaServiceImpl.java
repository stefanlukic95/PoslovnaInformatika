package poslovnaBanka.kurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KursnaListaServiceImpl implements KursnaListaService{

    @Autowired
    private  KursnaListaRepository kursnaListaRepository;

    @Override
    public List<KursnaLista> findAll() {
        return kursnaListaRepository.findAll();
    }
}
