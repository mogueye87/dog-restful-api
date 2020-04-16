package com.mgueye.DogRestApi.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mgueye.DogRestApi.entity.Dog;
import com.mgueye.DogRestApi.exception.BreedNotFoundException;
import com.mgueye.DogRestApi.exception.DogNotFoundException;
import com.mgueye.DogRestApi.repository.IDogRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private IDogRepository dogRepository;

    public Dog newDog(String name, String breed, String origin) {
        Dog dog = new Dog(name, breed, origin);
        return dogRepository.save(dog);
    }

    public boolean deleteDog(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public boolean deleteDogBreed(String breed) {
        List<Dog> allDogs = (List<Dog>) dogRepository.findAll();
        Predicate<Dog> dogPredicate = dog -> dog.getBreed().equals(breed);
        Function<Dog, Boolean> dogBooleanFunction = dog -> {
            dogRepository.delete(dog);
            return true;
        };

        Optional<Boolean> optionalBoolean = allDogs.stream().filter(dogPredicate).map(dogBooleanFunction).findAny();

        if (optionalBoolean.isPresent()) {
          return optionalBoolean.get().booleanValue();
        } else {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
    }

    public Dog updateDogName(String name, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        // Check if the dog is present
        if (optionalDog.isPresent()) {
            optionalDog.ifPresent((Dog d) -> d.setName(name));
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog with id " + id, id);
        }
    }
}
