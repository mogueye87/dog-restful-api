package com.mgueye.DogRestApi.web;

import com.mgueye.DogRestApi.entity.Dog;
import com.mgueye.DogRestApi.repository.IDogRepository;
import com.mgueye.DogRestApi.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class DogRestController {

    @Autowired
    private IDogService dogService;

    @GetMapping("/dog")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> allDogs = dogService.findAllDogs();
        return new ResponseEntity<List<Dog>>(allDogs, HttpStatus.OK);
    }

    @GetMapping("/dog/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable long id){

        Optional<Dog> dog = dogService.retrieveDogById(id);
        return new ResponseEntity<Dog>(dog.get(), HttpStatus.OK);
    }
}
