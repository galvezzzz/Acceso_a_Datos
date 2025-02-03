package org.example.repository;

import org.example.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {


    List<Manufacturer> findAllByManufacturerYear(Integer year);

}
