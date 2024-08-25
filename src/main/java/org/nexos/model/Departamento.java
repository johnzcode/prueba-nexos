package org.nexos.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departamento_codigo", nullable = false, unique = true)
    private String codigo;

    @Column(name = "departamento_nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_hora_crea", updatable = false)
    private LocalDateTime fechaHoraCrea;

    @Column(name = "fecha_hora_modifica")
    private LocalDateTime fechaHoraModifica;
}
