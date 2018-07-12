package poslovnaBanka.racuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VrstePlacanjaServiceImpl implements VrstePlacanjaService{

    @Autowired
    private VrstePlacanjaRepository vrstePlacanjaRepository;

    @Override
    public List<VrstePlacanja> findAll() {
        return vrstePlacanjaRepository.findAll();
    }

    @Override
    public VrstePlacanja findOne(long id) {
        return vrstePlacanjaRepository.findOne(id);
    }
}
