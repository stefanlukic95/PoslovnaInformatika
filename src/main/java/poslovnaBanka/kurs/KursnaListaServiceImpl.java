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

    @Override
    public KursnaLista findLast() {
        List<KursnaLista> liste = findAll();
        if(liste.size() > 0) {
            KursnaLista lista = liste.get(0);
            for (KursnaLista k : liste) {
                if (k.getDatum().after(lista.getDatum())) {
                    lista = k;
                }
            }
            return lista;
        }
        return null;
    }
}
