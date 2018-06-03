
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
