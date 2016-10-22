package com.ksimeo.arsu.view.beans;

import com.ksimeo.arsu.core.models.ProdGroup;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo 15.08.2015.
 */
@ManagedBean
@ViewScoped
public class MainBean implements Serializable {
    private List<ProdGroup> types;

    public MainBean() {
        types = new ArrayList<ProdGroup>();
        types.add(new ProdGroup(1, "Крупная бытовая техника"));
        types.add(new ProdGroup(2, "Кухонная техника"));
        types.add(new ProdGroup(3, "Электроника"));
    }

    public List<ProdGroup> getTypes() {
        return types;
    }

    public void setTypes(List<ProdGroup> types) {
        this.types = types;
    }
}
