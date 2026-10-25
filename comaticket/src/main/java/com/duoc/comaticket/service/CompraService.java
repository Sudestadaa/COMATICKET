package com.duoc.comaticket.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.duoc.comaticket.dto.CompraRequest;
import com.duoc.comaticket.dto.CompraResponse;
import com.duoc.comaticket.model.Compra;
import com.duoc.comaticket.model.Evento;
import com.duoc.comaticket.repository.CompraRepository;
import com.duoc.comaticket.repository.EventoRepository;

@Service
public class CompraService {

    private final CompraRepository compraRepository;
    private final EventoRepository eventoRepository;

    public CompraService(CompraRepository compraRepository, EventoRepository eventoRepository) {
        this.compraRepository = compraRepository;
        this.eventoRepository = eventoRepository;
    }

    public CompraResponse procesarCompra(CompraRequest request) {
        Evento evento = eventoRepository.findById(request.getEventoId())
                .orElseThrow(() -> new RuntimeException("El evento con ID " + request.getEventoId() + " no fue encontrado."));

        Double precioUnitario = evento.getPrecio();
        Double precioTotal = precioUnitario * request.getCantidad();
        LocalDateTime fechaActual = LocalDateTime.now();

        Compra compra = new Compra(evento, request.getCantidad(), precioUnitario, precioTotal, fechaActual);
        Compra compraGuardada = compraRepository.save(compra);

        return new CompraResponse(
                compraGuardada.getId(),
                evento.getNombre(),
                compraGuardada.getCantidad(),
                compraGuardada.getPrecioUnitario(),
                compraGuardada.getPrecioTotal(),
                compraGuardada.getFechaCompra()
        );
    }

    public List<CompraResponse> obtenerTodasLasCompras() {
        return compraRepository.findAll().stream().map(compra -> new CompraResponse(
                compra.getId(),
                compra.getEvento().getNombre(),
                compra.getCantidad(),
                compra.getPrecioUnitario(),
                compra.getPrecioTotal(),
                compra.getFechaCompra()
        )).collect(Collectors.toList());
    }
}