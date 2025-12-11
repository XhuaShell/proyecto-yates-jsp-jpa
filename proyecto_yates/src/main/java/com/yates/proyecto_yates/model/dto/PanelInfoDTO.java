package com.yates.proyecto_yates.model.dto;

import java.util.List;

public class PanelInfoDTO {

    private String titulo;
    private String linkPanel;
    private List<PanelSeccionDTO> secciones;

    public PanelInfoDTO() {
    }

    public PanelInfoDTO(String titulo, String linkPanel, List<PanelSeccionDTO> secciones) {
        this.titulo = titulo;
        this.linkPanel = linkPanel;
        this.secciones = secciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinkPanel() {
        return linkPanel;
    }

    public void setLinkPanel(String linkPanel) {
        this.linkPanel = linkPanel;
    }

    public List<PanelSeccionDTO> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<PanelSeccionDTO> secciones) {
        this.secciones = secciones;
    }
}
