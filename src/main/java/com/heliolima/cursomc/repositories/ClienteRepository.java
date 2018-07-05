
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    @Transactional(readOnly = true)
    Cliente findByEmail(String email);
}
