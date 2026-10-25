package com.duoc.comaticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.comaticket.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}