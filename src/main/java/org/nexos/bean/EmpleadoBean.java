package org.nexos.bean;

import javax.annotation.PostConstruct;
import lombok.Data;
import org.nexos.dao.DepartamentoDAO;
import org.nexos.dao.EmpleadoDAO;
import org.nexos.model.Departamento;
import org.nexos.model.Empleado;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
@Data
@RequestScoped
public class EmpleadoBean {

    @Inject
    private EmpleadoDAO empleadoDAO;

    @Inject
    private DepartamentoDAO departamentoDAO;

    private Empleado empleado = new Empleado();
    private List<Empleado> empleados;
    private List<Departamento> departamentos;

    @PostConstruct
    public void init() {
        // Crear y persistir datos de prueba
        if (empleadoDAO.findAll().isEmpty()) {
            Departamento dep1 = departamentoDAO.findById(1L);
            Departamento dep2 = departamentoDAO.findById(2L);

            Empleado emp1 = new Empleado();
            emp1.setDocumentoTipo("CC");
            emp1.setDocumentoNumero("123456789");
            emp1.setNombres("Juan");
            emp1.setApellidos("Pérez");
            emp1.setDepartamento(dep1);
            emp1.setCiudad("Bogotá");
            emp1.setDireccion("Calle 123");
            emp1.setCorreoElectronico("juan.perez@example.com");
            emp1.setTelefono("1234567890");
            emp1.setFechaHoraCrea(LocalDateTime.now());
            empleadoDAO.save(emp1);

            Empleado emp2 = new Empleado();
            emp2.setDocumentoTipo("TI");
            emp2.setDocumentoNumero("987654321");
            emp2.setNombres("Ana");
            emp2.setApellidos("Gómez");
            emp2.setDepartamento(dep2);
            emp2.setCiudad("Medellín");
            emp2.setDireccion("Carrera 456");
            emp2.setCorreoElectronico("ana.gomez@example.com");
            emp2.setTelefono("0987654321");
            emp2.setFechaHoraCrea(LocalDateTime.now());
            empleadoDAO.save(emp2);
        }

        empleados = empleadoDAO.findAll();
        departamentos = departamentoDAO.findAll();
    }

    public List<Empleado> getEmpleados() {
        return empleadoDAO.findAll();
    }

    public String save() {
        empleadoDAO.save(empleado);
        return "list?faces-redirect=true";
    }

    public String edit(Long id) {
        empleado = empleadoDAO.findById(id);
        return "form?faces-redirect=true";
    }

    public void delete(Long id) {
        empleadoDAO.delete(id);
    }

}
