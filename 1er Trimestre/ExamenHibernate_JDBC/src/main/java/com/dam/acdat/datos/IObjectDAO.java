package com.dam.acdat.datos;

import java.sql.SQLException;
import java.util.List;

public interface IObjectDAO {
    List<Object> getObjects() throws SQLException;
    boolean addObject(Object object) throws SQLException;
    Object getObject(Object object) throws SQLException;
    boolean updateObject(Object object) throws SQLException;
    boolean deleteObject(Object object) throws SQLException;
}
