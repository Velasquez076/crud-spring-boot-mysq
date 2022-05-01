package com.learn.crudspring.controller;

import com.learn.crudspring.entity.User;
import com.learn.crudspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    // Read an user in the Database by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> readUserById(@PathVariable Long id){
        Optional<User> oUser = userService.findById(id);

        // si no esta presente nos muestra un error 404, notfound
        if (!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }

    //Actualizar usuario por id
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User userDetails, @PathVariable Long id){
        Optional<User> user = userService.findById(id);

        if (!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        // se pasan los datos actualizados al nuevo objeto usuario
        user.get().setNombre(userDetails.getNombre());
        user.get().setApellido(userDetails.getApellido());
        user.get().setUser(userDetails.getUser());
        user.get().setTelefono(userDetails.getTelefono());
        user.get().setEmail(userDetails.getEmail());
        user.get().setPassword(userDetails.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        Optional<User> oUser = userService.findById(id);

        if (!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public Iterable<User> allUser(){
        return userService.findAll();
    }


}
