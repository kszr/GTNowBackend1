package com.gtnow.backend1;

import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.googlecode.objectify.ObjectifyService;
import com.gtnow.backend1.entity.User;

/**
 * This is another spot where you can set up the Jersey Filter if you wish.  I decided against it
 * in case you choose not to use Guice.  However, I am using this to set up Google Objectify instead.
 */
public class JerseyExampleServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        filter("/*").through(ObjectifyFilter.class);
        ObjectifyService.register(User.class);
    }
}
