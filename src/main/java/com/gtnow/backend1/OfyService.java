package com.gtnow.backend1;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.gtnow.backend1.entity.Building;
import com.gtnow.backend1.entity.User;

import groovy.lang.Buildable;

public class OfyService {
    static {
        ObjectifyService.register(User.class);
        ObjectifyService.register(Building.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();//prior to v.4.0 use .begin() , 
                                        //since v.4.0  use ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

}