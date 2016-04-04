package ru.stepanian.project.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Stepanian on 22.03.2016.
 */

@Entity
@Table
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private Long id;

    @Basic
    @Column
    private String name;

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

    /*Методы используются в конвертере, при реализации кнопок Добавить, Редактировать*/

    @Override
    public boolean equals(Object other) {
        return (other instanceof Brand) && (id != null)
                ? id.equals(((Brand) other).id)
                : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
                ? (this.getClass().hashCode() + id.hashCode())
                : super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Brand [%d, %s]", id, name);
    }

}
