package ru.stepanian.project.dao.interfaces;

import ru.stepanian.project.entities.Backpack;
import ru.stepanian.project.entities.Brand;

import java.util.List;

/**
 * Created by Stepanian on 22.03.2016.
 */

public interface BackpackDAO {

    public List<Backpack> listBackpacks();

    public void deleteRow (Long id);

    public void addBackpack (Backpack b);

    public List<Brand> getListBrands();

    public Backpack getBackpack( Long id );

    public void edit(Backpack backpack);

}
