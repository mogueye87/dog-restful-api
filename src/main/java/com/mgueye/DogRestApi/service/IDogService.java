package com.mgueye.DogRestApi.service;

import com.mgueye.DogRestApi.entity.Dog;

import java.util.List;
import java.util.Optional;

public interface IDogService {
    List<Dog> findAllDogs();
    Optional<Dog> retrieveDogById(long id);
}
