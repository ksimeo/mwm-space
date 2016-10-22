package com.ksimeo.arsu.admin.services;

import com.ksimeo.arsu.core.models.ProdType;

import java.util.List;

/**
 * Created by @author Ksimeo on 17.11.2015 at 13:26. For project: MArsMarketSpace.
 */
public interface ITypeService {

    void addType(ProdType prodType);
    ProdType getType(int id);
    List<ProdType> getAllTypes();
}
