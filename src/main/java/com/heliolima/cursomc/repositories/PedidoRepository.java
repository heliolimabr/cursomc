
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
