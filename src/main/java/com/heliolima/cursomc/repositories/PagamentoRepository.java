
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
