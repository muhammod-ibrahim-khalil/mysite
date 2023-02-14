package com.mysite.core.models.impl;
import com.mysite.core.models.MyList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Model(adaptables = SlingHttpServletRequest.class, adapters = MyList.class)
public class MyListImpl implements MyList {
    static final String  NONE = "none";
    static final String  ASC = "asc";
    static final String  DESC = "desc";

    @ValueMapValue
    private List<String> items;

    @ValueMapValue
    private String order;

    @PostConstruct
    public void initModel() {
        switch (order) {
            case NONE:
                items = items.stream().map(String::toUpperCase).collect(Collectors.toList());
                break;
            case ASC:
                items = items.stream().sorted().collect(Collectors.toList());
                break;
            case DESC:
                items = items.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                break;
        }
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }
}
