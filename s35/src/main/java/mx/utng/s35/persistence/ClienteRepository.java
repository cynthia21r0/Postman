package mx.utng.s35.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.utng.s35.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
