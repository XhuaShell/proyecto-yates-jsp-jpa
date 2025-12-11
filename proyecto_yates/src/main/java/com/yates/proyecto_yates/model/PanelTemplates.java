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
                        // ==========================
                        //       AMARRE SERVLET
                        // ==========================
                        new PanelSeccionDTO("AmarreServlet", List.of(
                                new PanelBotonDTO("Formulario", "/proyecto_yates/AmarreServlet?action=formulario"),
                                new PanelBotonDTO("Lista", "/proyecto_yates/AmarreServlet?action=lista"),
                                new PanelBotonDTO("Lista con Datos", "/proyecto_yates/AmarreServlet?action=lista1"),
                                new PanelBotonDTO("Edición", "/proyecto_yates/AmarreServlet?action=edicion"),
                                new PanelBotonDTO("Eliminar", "/proyecto_yates/AmarreServlet?action=delete"),
                                new PanelBotonDTO("Main", "/proyecto_yates/AmarreServlet?action=main")
                        )),
                        // ==========================
                        //     TIPO YATE SERVLET
                        // ==========================
                        new PanelSeccionDTO("TipoYateServlet", List.of(
                                new PanelBotonDTO("Formulario", "/proyecto_yates/TipoYateServlet?action=formulario"),
                                new PanelBotonDTO("Lista", "/proyecto_yates/TipoYateServlet?action=lista"),
                                new PanelBotonDTO("Lista con Datos", "/proyecto_yates/TipoYateServlet?action=lista1"),
                                new PanelBotonDTO("Edición", "/proyecto_yates/TipoYateServlet?action=edicion"),
                                new PanelBotonDTO("Eliminar", "/proyecto_yates/TipoYateServlet?action=delete"),
                                new PanelBotonDTO("Main", "/proyecto_yates/TipoYateServlet?action=main")
                        )),
                        // ==========================
                        //       USUARIO SERVLET
                        // ==========================
                        new PanelSeccionDTO("UsuarioServlet", List.of(
                                new PanelBotonDTO("Formulario", "/proyecto_yates/UsuarioServlet?action=formulario"),
                                new PanelBotonDTO("Lista", "/proyecto_yates/UsuarioServlet?action=lista"),
                                new PanelBotonDTO("Lista con Datos", "/proyecto_yates/UsuarioServlet?action=lista1"),
                                new PanelBotonDTO("Edición", "/proyecto_yates/UsuarioServlet?action=edicion"),
                                new PanelBotonDTO("Eliminar", "/proyecto_yates/UsuarioServlet?action=delete"),
                                new PanelBotonDTO("Main", "/proyecto_yates/UsuarioServlet?action=main")
                        )),
                        // ==========================
                        //        YATE SERVLET
                        // ==========================
                        new PanelSeccionDTO("YateServlet", List.of(
                                new PanelBotonDTO("Formulario", "/proyecto_yates/YateServlet?action=formulario"),
                                new PanelBotonDTO("Lista", "/proyecto_yates/YateServlet?action=lista"),
                                new PanelBotonDTO("Lista con Datos", "/proyecto_yates/YateServlet?action=lista1"),
                                new PanelBotonDTO("Edición", "/proyecto_yates/YateServlet?action=edicion"),
                                new PanelBotonDTO("Eliminar", "/proyecto_yates/YateServlet?action=delete"),
                                new PanelBotonDTO("Main", "/proyecto_yates/YateServlet?action=main")
                        )),
                        // ==========================
                        //        ZONA SERVLET
                        // ==========================
                        new PanelSeccionDTO("ZonaServlet", List.of(
                                new PanelBotonDTO("Formulario", "/proyecto_yates/ZonaServlet?action=formulario"),
                                new PanelBotonDTO("Lista", "/proyecto_yates/ZonaServlet?action=lista"),
                                new PanelBotonDTO("Lista con Datos", "/proyecto_yates/ZonaServlet?action=lista1"),
                                new PanelBotonDTO("Edición", "/proyecto_yates/ZonaServlet?action=edicion"),
                                new PanelBotonDTO("Eliminar", "/proyecto_yates/ZonaServlet?action=delete"),
                                new PanelBotonDTO("Main", "/proyecto_yates/ZonaServlet?action=main")
                        ))
                )
        );

    }
}
