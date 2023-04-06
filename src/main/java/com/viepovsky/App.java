package com.viepovsky;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.webapp.WebAppContext;

public class App {
    public static void main(String[] args) throws Exception {
        var webapp = new WebAppContext();
        webapp.setResourceBase("src/main/webapp");
        webapp.setContextPath("/");
        webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");
        Server server = new Server(8080);
        server.setHandler(webapp);
        server.addBean(new LifeCycle.Listener() {
            @Override
            public void lifeCycleStopping(LifeCycle event) {
                HibernateUtil.close();
            }
        });
        server.start();
        server.join();
    }
}
