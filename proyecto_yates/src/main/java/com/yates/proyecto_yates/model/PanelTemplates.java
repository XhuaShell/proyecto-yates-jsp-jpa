package com.yates.proyecto_yates.model;

import com.yates.proyecto_yates.model.dto.PanelInfoDTO;
import com.yates.proyecto_yates.model.dto.PanelSeccionDTO;
import com.yates.proyecto_yates.model.dto.PanelBotonDTO;
import java.util.List;

public class PanelTemplates {

    public static PanelInfoDTO panelSocio() {
        return new PanelInfoDTO(
                "Panel Socio",
                "/proyecto_yates/panel?typeuser=socio",
                List.of(
                        new PanelSeccionDTO("Amarres", List.of(
                                new PanelBotonDTO("Zonas", "/zona/lista"),
                                new PanelBotonDTO("Estadísticas", "")
                        )),
                        new PanelSeccionDTO("Gestión", List.of(
                                new PanelBotonDTO("Usuarios", ""),
                                new PanelBotonDTO("Reportes", ""),
                                new PanelBotonDTO("Registros", "")
                        )),
                        new PanelSeccionDTO("Cuenta", List.of(
                                new PanelBotonDTO("Actualización", "/socio/informacion")
                        ))
                )
        );
    }

    public static PanelInfoDTO panelAdmin() {
        return new PanelInfoDTO(
                "Panel de Administrador",
                "/proyecto_yates/panel?typeuser=admin",
                List.of(
                        new PanelSeccionDTO("Inicio", List.of(
                                new PanelBotonDTO("Amarres", "/amarre/lista"),
                                new PanelBotonDTO("Yates", "/yate/lista")
                        )),
                        new PanelSeccionDTO("Gestión", List.of(
                                new PanelBotonDTO("Zonas", "/zona/lista"),
                                new PanelBotonDTO("Empleados", "/funcionNoTerminada"),
                                new PanelBotonDTO("Ventas", "/funcionNoTerminada"),
                                new PanelBotonDTO("Servicios", "/funcionNoTerminada")
                        )),
                        new PanelSeccionDTO("Cuenta", List.of(
                                new PanelBotonDTO("Actualización", "/socio/informacion")
                        ))
                )
        );
    }
}
