package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.PanelFactory;
import com.yates.proyecto_yates.model.dto.PanelBotonDTO;
import com.yates.proyecto_yates.model.dto.PanelInfoDTO;
import com.yates.proyecto_yates.model.dto.PanelSeccionDTO;


public class pruebapanel {
    public static void main(String[] args) {
        PanelInfoDTO panel = PanelFactory.getPanel("ADMIN");
        
        System.out.println(panel.getTitulo());
        System.out.println(panel.getLinkPanel());
        
        for ( PanelSeccionDTO  seccion : panel.getSecciones() ) {
            System.out.println(seccion.getTitulo());
            for ( PanelBotonDTO  boton : seccion.getBotones()) {
                System.out.println(boton.getNombre() + ":" + boton.getLink());
            }   
        }
    }
}
