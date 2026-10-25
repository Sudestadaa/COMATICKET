package com.duoc.comaticket.dto;

import java.time.LocalDateTime;

public class CompraResponse {
    private Long idCompra;
    private String evento;
    private Integer numeroEntradas;
    private Double precioUnitario;
    private Double precioTotal;
    private LocalDateTime fechaCompra;

    public CompraResponse(Long idCompra, String evento, Integer numeroEntradas, Double precioUnitario, Double precioTotal, LocalDateTime fechaCompra) {
        this.idCompra = idCompra;
        this.evento = evento;
        this.numeroEntradas = numeroEntradas;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
        this.fechaCompra = fechaCompra;
    }

    public Long getIdCompra() { return idCompra; }
    public String getEvento() { return evento; }
    public Integer getNumeroEntradas() { return numeroEntradas; }
    public Double getPrecioUnitario() { return precioUnitario; }
    public Double getPrecioTotal() { return precioTotal; }
    public LocalDateTime getFechaCompra() { return fechaCompra; }
}