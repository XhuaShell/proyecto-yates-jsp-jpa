package com.yates.proyecto_yates.model.dto;

import java.util.List;

public class PanelSeccionDTO {

    private String titulo;
    private List<PanelBotonDTO> botones;

    public PanelSeccionDTO() {
    }

    public PanelSeccionDTO(String titulo, List<PanelBotonDTO> botones) {
        this.titulo = titulo;
        this.botones = botones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<PanelBotonDTO> getBotones() {
        return botones;
    }

    public void setBotones(List<PanelBotonDTO> botones) {
        this.botones = botones;
    }
}
