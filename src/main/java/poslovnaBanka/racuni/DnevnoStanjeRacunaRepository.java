package poslovnaBanka.racuni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnevnoStanjeRacunaRepository extends JpaRepository<DnevnoStanjeRacuna,Long> {
}
