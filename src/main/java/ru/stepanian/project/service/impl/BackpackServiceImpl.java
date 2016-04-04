package ru.stepanian.project.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stepanian.project.dao.interfaces.BackpackDAO;
import ru.stepanian.project.entities.Backpack;
import ru.stepanian.project.entities.Brand;
import ru.stepanian.project.service.interfaces.BackpackService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Stepanian on 27.03.2016.
 */

@Service
@ManagedBean(name = "backpackService") /*Аннотации НУЖНЫ (для доступности на JSF страницах)*/
@SessionScoped
public class BackpackServiceImpl implements BackpackService {

    private BackpackDAO backpackDAO;

    public void setBackpackDAO(BackpackDAO backpackDAO) {
        this.backpackDAO = backpackDAO;
    }

    @Transactional
    @Override
    public List<Backpack> listBackpacks() {
        return this.backpackDAO.listBackpacks();
    }

    @Transactional
    @Override
    public void deleteRow(Long id) {
        backpackDAO.deleteRow(id);
    }

    @Transactional
    @Override
    public void addBackpack(Backpack b) {
        backpackDAO.addBackpack(b);
    }

    @Transactional
    @Override
    public List<Brand> getListBrands() {
        return backpackDAO.getListBrands();
    }

    @Transactional
    @Override
    public Backpack getBackpack( Long id ) {
        return backpackDAO.getBackpack(id);
    }

    @Transactional
    @Override
    public void edit(Backpack backpack) {
        backpackDAO.edit(backpack);
    }

}
