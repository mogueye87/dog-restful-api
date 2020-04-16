package com.mgueye.DogRestApi.repository;

import com.mgueye.DogRestApi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IDogRepository extends CrudRepository<Dog, Long> {
//   @Query("select d.breed from Dog d")
//   List<String> findDogBreeds();
//
//   @Query("select d.breed from Dog d where d.id=:id")
//   String findDogBreedById(String breed, long id);
//
//   @Query("select d.name from Dog d")
//   List<String> findAllDogNames();
//
//   @Query("delete from Dog d where d.breed=:breed")
//   boolean deleteDogBreed(String breed);
//
//   @Query("update Dog d set d.name=:updatedName where d.id=:id")
//   Dog updateDogName(String updatedName, long id);
}
