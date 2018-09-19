package poslovnaBanka.racuni;


import poslovnaBanka.analitikaIzvoda.AnalitikaIzvoda;

import java.io.IOException;

public interface ClearingService {

    void increaseSum(Clearing clearing, double iznos);
    Clearing exportClearing(Clearing clearing) throws IOException;
    Clearing save(Clearing clearing);
}
