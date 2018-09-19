package poslovnaBanka.banka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankaServiceImpl implements BankaService{

    @Autowired
    private BankaRepository bankaRepository;

    @Override
    public Banka getBanka() {
        List<Banka> banke = findAll();
        Banka banka = banke.get(0);
        return banka;
    }

    @Override
    public List<Banka> findAll() {
        return bankaRepository.findAll();
    }

    @Override
    public Banka findOne(long id) {
        return bankaRepository.findOne(id);
    }

    @Override
    public Banka save(Banka banka) {
        return bankaRepository.save(banka);
    }

}
