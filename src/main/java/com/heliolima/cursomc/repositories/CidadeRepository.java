
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    
}
