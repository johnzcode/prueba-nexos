package org.nexos.bean;

import javax.annotation.PostConstruct;
import lombok.Data;
import org.nexos.dao.DepartamentoDAO;
import org.nexos.model.Departamento;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
@Data
@RequestScoped
public class DepartamentoBean {

    @Inject
    private DepartamentoDAO departamentoDAO;

    private Departamento departamento = new Departamento();

    public List<Departamento> getDepartamentos() {
        List<Departamento> departamentos = departamentoDAO.findAll();
        if (departamentos == null || departamentos.isEmpty()) {
            System.out.println("No se encontraron departamentos");
        }
        return departamentos;
    }

    private List<Departamento> departamentos;

    @PostConstruct
    public void init() {
        // Crear y persistir datos de prueba
        if (departamentoDAO.findAll().isEmpty()) {
            Departamento dep1 = new Departamento();
            dep1.setCodigo("DEP001");
            dep1.setNombre("Recursos Humanos");
            dep1.setFechaHoraCrea(LocalDateTime.now());
            departamentoDAO.save(dep1);

            Departamento dep2 = new Departamento();
            dep2.setCodigo("DEP002");
            dep2.setNombre("IT");
            dep2.setFechaHoraCrea(LocalDateTime.now());
            departamentoDAO.save(dep2);
        }

        departamentos = departamentoDAO.findAll();
    }

    public String save() {
        try {
            departamentoDAO.save(departamento);
            return "list?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();;
            return null;
        }

    }

    public String edit(Long id) {
        departamento = departamentoDAO.findById(id);
        return "form?faces-redirect=true";
    }

    public String delete(Long id) {
        departamentoDAO.delete(id);
        return "list?faces-redirect=true";
    }

}
