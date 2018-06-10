
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
