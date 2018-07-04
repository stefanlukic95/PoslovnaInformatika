package poslovnaBanka.klijent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PravnoLiceRepository extends JpaRepository<PravnoLice, Long> {
}
