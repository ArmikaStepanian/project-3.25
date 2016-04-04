package ru.stepanian.project.entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Stepanian on 22.03.2016.
 */

@Entity
@Table
@ManagedBean(name = "backpack")
@RequestScoped
public class Backpack implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column  /*Если сгенерированное имя класса, поля, отличается от имени таблицы, колонки соответственно, то явно прописываем имя (name=" ") */
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="brand",referencedColumnName="id")
    private Brand brand;

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
