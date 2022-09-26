package com.algaworks.algalog.domain.repository;

import org.springframework.stereotype.Repository;
import com.algaworks.algalog.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long> {
	
}
