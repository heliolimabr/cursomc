
package com.heliolima.cursomc.repositories;

import com.heliolima.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Helio Lima
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    
}
