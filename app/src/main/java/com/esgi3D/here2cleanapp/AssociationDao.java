package com.esgi3D.here2cleanapp;

import java.util.List;

public interface AssociationDao {
    public List<Association> getAssociations();
    public Association getAssociationByMail(String mail);
    public Association getAssociationByName(String name);

}
