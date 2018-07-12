package poslovnaBanka.kurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KursValutiServiceImpl implements KursValutiService {


    @Autowired
    private  KursValutiRepository kursValutiRepository;

    @Override
    public List<KursValuti> findAll() {
        return kursValutiRepository.findAll();
    }
}
