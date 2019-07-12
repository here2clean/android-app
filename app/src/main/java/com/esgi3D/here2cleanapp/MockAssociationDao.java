package com.esgi3D.here2cleanapp;

import java.util.ArrayList;
import java.util.List;

public class MockAssociationDao implements AssociationDao {



    @Override
    public List<Association> getAssociations() {
        List<Association> associations = new ArrayList<Association>();

        Association ass1 = new AssociationBuilder(1)
            .WithDescription("A description")
            .Named("A name")
            .WithRNA(500l)
            .WithEmail("a@a.fr")
            .WithPassword("aa")
            .build();

        associations.add(ass1);

        Association ass2 = new AssociationBuilder(1)
                .WithDescription("Another description")
                .Named("Another name")
                .WithRNA(500l)
                .WithEmail("a@a.fr")
                .WithPassword("aa")
                .build();

        associations.add(ass2);
       return associations;
    }

    @Override
    public Association getAssociationByMail(String mail) {
        Association ass1 = new AssociationBuilder(1)
                .WithDescription("A description")
                .Named("A name")
                .WithRNA(500l)
                .WithEmail("a@a.fr")
                .WithPassword("aa")
                .build();
        return ass1;
    }

    @Override
    public Association getAssociationByName(String name) {
        Association ass1 = new AssociationBuilder(1)
                .WithDescription("A description")
                .Named("A name")
                .WithRNA(500l)
                .WithEmail("a@a.fr")
                .WithPassword("aa")
                .build();

        return ass1;
    }
}
