package com.ksimeo.arsu.view.services;

import com.ksimeo.arsu.core.models.ProdGroup;
import com.ksimeo.arsu.view.server.IRestServer;
import com.ksimeo.arsu.view.server.RestServerMock;

import java.util.List;

/**
 * @author Ksimeo 18.08.2015.
 */
public enum ProdTypeService {

    INSTANCE;

    private IRestServer rs;

    ProdTypeService() {
        rs = new RestServerMock();
    }

    public List<ProdGroup> getAllTypes() {
        return rs.getAllGroups();
    }
}
