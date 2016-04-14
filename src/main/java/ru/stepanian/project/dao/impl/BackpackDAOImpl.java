package ru.stepanian.project.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.stepanian.project.dao.interfaces.BackpackDAO;
import ru.stepanian.project.entities.Backpack;
import ru.stepanian.project.entities.Brand;

import java.util.List;

/**
 * Created by Stepanian on 22.03.2016.
 */

@Repository
public class BackpackDAOImpl implements BackpackDAO {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Backpack> listBackpacks() {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select bp.id as id, bp.name as name, bp.brand as brand from Backpack bp order by bp.id")
                .setResultTransformer(Transformers.aliasToBean(Backpack.class));
        return (List<Backpack>)query.list();
    }

    @Override
    public void deleteRow(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "delete from Backpack where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        logger.info("Backpack deleted successfully, Backpack Details=" + id);
    }

    @Override
    public void addBackpack(Backpack b) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(b);
        logger.info("Backpack added successfully, Backpack Details=" + b);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Brand> getListBrands() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Brand> listBrands = session.createQuery("from Brand order by name").list();
        for (Brand brand : listBrands) {
            logger.info("Brand List:" + brand );
        }
        return listBrands;
    }

    @Override
    public Backpack getBackpack( Long id ) {
        Session session = this.sessionFactory.getCurrentSession();
        Backpack backpack = session.get(Backpack.class, id);
        logger.info("Backpack:" + backpack );
        return backpack;
    }

    @Override
    public void edit(Backpack backpack) {
        Session session = this.sessionFactory.getCurrentSession();
        Backpack existingBackpack = session.get(Backpack.class, backpack.getId());
        existingBackpack.setName(backpack.getName());
        existingBackpack.setBrand(backpack.getBrand());
        session.save(existingBackpack);
        logger.info("Backpack edited successfully, Backpack Details=" + backpack);
    }

}