package poslovnaBanka.banka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankaServiceImpl implements BankaService{

    @Autowired
    private BankaRepository bankaRepository;

    @Override
    public List<Banka> findAll() {
        return bankaRepository.findAll();
    }

    @Override
    public Banka findOne(long id) {
        return bankaRepository.findOne(id);
    }
}
