package com.mgueye.DogRestApi.service;

import com.mgueye.DogRestApi.entity.Dog;
import com.mgueye.DogRestApi.repository.IDogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements IDogService {
    @Autowired
    private IDogRepository dogRepository;

    @Override
    public List<Dog> findAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public Optional<Dog> retrieveDogById(long id) {
        return dogRepository.findById(id);
    }

}
