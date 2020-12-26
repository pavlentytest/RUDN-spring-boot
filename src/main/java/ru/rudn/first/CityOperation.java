package ru.rudn.first;

import org.springframework.data.repository.CrudRepository;

// CRUD
// Create - Read - Update - Delete

public interface CityOperation extends CrudRepository<City, Integer> {
}
