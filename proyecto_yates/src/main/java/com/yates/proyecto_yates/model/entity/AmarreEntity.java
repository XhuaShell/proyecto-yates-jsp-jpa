package com.yates.proyecto_yates.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "amarres")
public class AmarreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_amarre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaEntity zona;

    @OneToMany(mappedBy = "amarre")
    private List<VentaEntity> historialVentas;

    public AmarreEntity() {
    }

    public AmarreEntity(Long num_amarre, ZonaEntity zona) {
        this.num_amarre = num_amarre;
        this.zona = zona;
    }

    public Long getNum_amarre() {
        return num_amarre;
    }

    public void setNum_amarre(Long num_amarre) {
        this.num_amarre = num_amarre;
    }

    public ZonaEntity getZona() {
        return zona;
    }

    public void setZona(ZonaEntity zona) {
        this.zona = zona;
    }

}
