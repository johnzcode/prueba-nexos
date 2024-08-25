package org.nexos.model;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "documento_tipo", nullable = false)
    private String documentoTipo;

    @Column(name = "documento_numero", nullable = false, unique = true)
    private String documentoNumero;

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "departamentos_id", nullable = false)
    private Departamento departamento;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_hora_crea", updatable = false)
    private LocalDateTime fechaHoraCrea;

    @Column(name = "fecha_hora_modifica")
    private LocalDateTime fechaHoraModifica;
}
