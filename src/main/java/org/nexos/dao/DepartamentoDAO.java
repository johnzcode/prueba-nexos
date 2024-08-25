package org.nexos.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.nexos.model.Departamento;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class DepartamentoDAO {

    @SuppressWarnings("unused")
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        if (entityManager == null) {
            System.out.println("EntityManager is null in init method");
        } else {
            System.out.println("EntityManager initialized successfully");
        }
    }

    @Transactional
    public void save(Departamento departamento){
        System.out.println("entra");
        if (departamento.getId() == null){
            entityManager.persist(departamento);
        }else {
            entityManager.merge(departamento);
        }
    }

    @Transactional
    public void delete(Long id){
        Departamento departamento = entityManager.find(Departamento.class, id);
        if (departamento != null){
            entityManager.remove(departamento);
        }
    }

    public Departamento findById(Long id){
        return entityManager.find(Departamento.class, id);
    }

    public List<Departamento> findAll(){
        return entityManager.createQuery("SELECT d from Departamento d", Departamento.class).getResultList();
    }
}
