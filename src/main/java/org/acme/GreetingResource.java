package org.acme;

import io.quarkus.hibernate.orm.PersistenceUnit;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.basicClass.BasicClass;


import java.util.UUID;

@Path("/hello")
public class GreetingResource {
    @Inject
    @PersistenceUnit("Classes")
    EntityManager entityManager;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }


    @GET
    public BasicClass getClassFromDb(){return entityManager.find(BasicClass.class, UUID.randomUUID());}
}
