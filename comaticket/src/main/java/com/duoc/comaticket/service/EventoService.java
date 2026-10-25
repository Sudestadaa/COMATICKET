package com.duoc.comaticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duoc.comaticket.model.Evento;
import com.duoc.comaticket.repository.EventoRepository;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> obtenerTodos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> obtenerPorId(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> actualizar(Long id, Evento eventoDetalles) {
        return eventoRepository.findById(id).map(evento -> {
            evento.setNombre(eventoDetalles.getNombre());
            evento.setFecha(eventoDetalles.getFecha());
            evento.setPrecio(eventoDetalles.getPrecio());
            return eventoRepository.save(evento);
        });
    }

    public boolean eliminar(Long id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}