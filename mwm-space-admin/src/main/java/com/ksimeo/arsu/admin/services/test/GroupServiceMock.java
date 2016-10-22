package com.ksimeo.arsu.admin.services.test;

import com.ksimeo.arsu.admin.services.IGroupService;
import com.ksimeo.arsu.core.models.ProdGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author Ksimeo on 17.11.2015 at 16:50. For project: MArsMarketSpace.
 */
@Service
public class GroupServiceMock implements IGroupService {

    private List<ProdGroup> groups;

    public GroupServiceMock() {
        groups = new ArrayList<>();
        groups.add(new ProdGroup(1, "Кухонная техника"));
        groups.add(new ProdGroup(2, "Электроника"));
        groups.add(new ProdGroup(3, "Самовары"));
        groups.add(new ProdGroup(4, "Компьютеры"));
        groups.add(new ProdGroup(5, "Ковры"));
    }

    public List<ProdGroup> getGroups(int id) {
        return groups;
    }

    public void addGroup(ProdGroup prodGroup) {
        groups.add(prodGroup);
    }
}
