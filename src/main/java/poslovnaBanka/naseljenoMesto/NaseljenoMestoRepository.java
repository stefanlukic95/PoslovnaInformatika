package poslovnaBanka.naseljenoMesto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaseljenoMestoRepository extends JpaRepository<NaseljenoMesto, Long>{
}
