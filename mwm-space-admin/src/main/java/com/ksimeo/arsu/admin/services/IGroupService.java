package com.ksimeo.arsu.admin.services;

import com.ksimeo.arsu.core.models.ProdGroup;

import java.util.List;

/**
 * Created by @author Ksimeo on 17.11.2015 at 16:48. For project: MArsMarketSpace.
 */
public interface IGroupService {
    List<ProdGroup> getGroups(int id);
    void addGroup(ProdGroup prodGroup);
}
