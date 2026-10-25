package com.duoc.comaticket.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.comaticket.dto.CompraRequest;
import com.duoc.comaticket.dto.CompraResponse;
import com.duoc.comaticket.service.CompraService;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    // POST /api/compras -> Comprar entradas para un evento
    @PostMapping
    public ResponseEntity<CompraResponse> realizarCompra(@RequestBody CompraRequest request) {
        CompraResponse resumen = compraService.procesarCompra(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resumen);
    }

    // GET /api/compras -> Historial de compras generadas
    @GetMapping
    public ResponseEntity<List<CompraResponse>> listarCompras() {
        return ResponseEntity.ok(compraService.obtenerTodasLasCompras());
    }
}