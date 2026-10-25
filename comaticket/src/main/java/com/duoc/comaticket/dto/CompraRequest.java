package com.duoc.comaticket.dto;

public class CompraRequest {
    private Long eventoId;
    private Integer cantidad;

    public CompraRequest() {}

    public Long getEventoId() { return eventoId; }
    public void setEventoId(Long eventoId) { this.eventoId = eventoId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}