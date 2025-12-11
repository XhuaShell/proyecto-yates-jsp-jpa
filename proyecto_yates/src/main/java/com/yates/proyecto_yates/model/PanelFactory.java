package com.yates.proyecto_yates.model;

import com.yates.proyecto_yates.model.dto.PanelInfoDTO;
import java.util.Map;

public class PanelFactory {

    private static final Map<String, PanelInfoDTO> PANELS = Map.of(
            "SOCIO", PanelTemplates.panelSocio(),
            "ADMIN", PanelTemplates.panelAdmin()
    );

    public static PanelInfoDTO getPanel(String tipoUsuario) {
        return PANELS.get(tipoUsuario);
    }
}
