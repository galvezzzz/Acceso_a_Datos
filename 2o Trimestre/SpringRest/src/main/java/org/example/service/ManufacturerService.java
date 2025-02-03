package org.example.service;

import org.example.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    //RETRIEVE
    List<Manufacturer> findAll();

    List<Manufacturer> findAllByManufacturerYear(Integer manufacturerYear);

    Optional<Manufacturer> findById(Long id);

    Optional<Manufacturer> findByName(String name);

    // CREATE / UPDATE
    Manufacturer save(Manufacturer manufacturer);

    // DELETE
    void deleteById(Long id);
    void deleteAll();

    // Más lógica de negocio
    // 1. Coches fabricados
    // 2. Beneficios obtenidos
    // 3. ...
}
