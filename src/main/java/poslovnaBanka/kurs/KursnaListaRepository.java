package poslovnaBanka.kurs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursnaListaRepository  extends JpaRepository<KursnaLista,Long>{
}
