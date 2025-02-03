package org.example.service;

import org.example.model.Manufacturer;
import org.example.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository repository;

    public ManufacturerServiceImpl(ManufacturerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Manufacturer> findAllByManufacturerYear(Integer manufacturerYear) {
        Objects.requireNonNull(manufacturerYear);
        return this.repository.findAllByManufacturerYear(manufacturerYear);
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<Manufacturer> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        this.repository.save(manufacturer);
        return manufacturer;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
