package org.nexos.dao;

import org.nexos.model.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class EmpleadoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Empleado empleado){
        if (empleado.getId() == null){
            entityManager.persist(empleado);
        }else {
            entityManager.merge(empleado);
        }
    }

    @Transactional
    public void delete(Long id){
        Empleado empleado = entityManager.find(Empleado.class, id);
        if (empleado != null) {
            entityManager.remove(empleado);
        }
    }

    public Empleado findById(Long id) {
        return entityManager.find(Empleado.class, id);
    }

    public List<Empleado> findAll() {
        return entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }
}
