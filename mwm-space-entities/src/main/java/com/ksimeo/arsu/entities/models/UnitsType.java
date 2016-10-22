package com.ksimeo.arsu.core.models;

/**
 * @author Ksimeo 25.08.2015.
 */
public enum UnitsType {
    PIECE("шт."), LITER("л"), KG("кг");
    private String name;

    UnitsType(String name) {
        this.name = name;
    }
}