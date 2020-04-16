package com.mgueye.DogRestApi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mgueye.DogRestApi.entity.Dog;
import com.mgueye.DogRestApi.exception.DogNotFoundException;
import com.mgueye.DogRestApi.repository.IDogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private IDogRepository dogRepository;

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog with id " + id + " is n ot found ", id);
        }
    }
}
