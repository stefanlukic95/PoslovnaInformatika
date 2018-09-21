package poslovnaBanka.racuni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UkidanjeRacunaRepository extends JpaRepository<UkidanjeRacuna, Long>{
}
