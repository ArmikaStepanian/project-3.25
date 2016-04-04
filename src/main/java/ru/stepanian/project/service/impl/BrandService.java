package ru.stepanian.project.service.impl;

import ru.stepanian.project.entities.Brand;
import ru.stepanian.project.service.interfaces.BackpackService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stepanian on 28.03.2016.
 */

@ManagedBean(name = "brandService")
@RequestScoped
public class BrandService implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{backpackService}")
    private BackpackService backpackService;

    private List<Brand> list;
    private List<SelectItem> selectItems = new ArrayList<SelectItem>();

    @PostConstruct
    public void init() {
        list = backpackService.getListBrands();
        for (Brand br : list) {
            selectItems.add(new SelectItem(br, br.getName()));
        }
    }

    public BackpackService getBackpackService() {
        return backpackService;
    }

    public void setBackpackService(BackpackService backpackService) {
        this.backpackService = backpackService;
    }

    public List<Brand> getList() {
        return list;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

}