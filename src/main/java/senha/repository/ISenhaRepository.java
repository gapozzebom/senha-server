package senha.repository;

import java.util.Optional;
import senha.model.Senha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISenhaRepository extends JpaRepository<Senha, Long> {
    Optional<Senha> findTopByTpoFilaOrderByTpoFilaDescNumeroDesc (String tpoFila);
    Optional<Senha> findTopByIsDeletedOrderByTpoFilaDescNumeroAsc (boolean isDeleted);
    Optional<Senha> findTopByIsDeletedOrderByChamadoEmDesc (boolean isDeleted);
}
