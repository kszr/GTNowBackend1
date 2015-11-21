package com.gtnow.backend1;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.gtnow.backend1.entity.Building;
import com.gtnow.backend1.entity.User;
import com.gtnow.backend1.entity.Event;
import com.gtnow.backend1.entity.Group;
import com.gtnow.backend1.entity.Invitation;
import com.gtnow.backend1.entity.EventSchedule;

public class OfyService {
    static {
        ObjectifyService.register(User.class);
        ObjectifyService.register(Building.class);
        ObjectifyService.register(Event.class);
        ObjectifyService.register(EventSchedule.class);
        ObjectifyService.register(Group.class);
        ObjectifyService.register(Invitation.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();//prior to v.4.0 use .begin() , 
                                        //since v.4.0  use ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

}