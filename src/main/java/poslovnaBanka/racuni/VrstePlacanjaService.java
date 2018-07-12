package poslovnaBanka.racuni;

import java.util.List;

public interface VrstePlacanjaService {

    List<VrstePlacanja> findAll();
    VrstePlacanja findOne(long id);
}
