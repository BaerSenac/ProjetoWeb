package com.sp.senac.br.demo.dao;

import com.sp.senac.br.demo.model.VisitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitanteDAO extends JpaRepository <VisitanteEntity, Integer> {
}
