
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
