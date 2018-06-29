package poslovnaBanka.drzava;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Long>{
}
