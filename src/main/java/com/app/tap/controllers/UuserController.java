package com.app.tap.controllers;

import com.app.tap.entitites.Uuser;
import com.app.tap.entitites.dtos.Uuser_Create_Dto;
import com.app.tap.entitites.dtos.Uuser_Get_Dto;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.service.UuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UuserController {

    @Autowired
    UuserService _uuserService;

    @PostMapping("/create")
    public ResponseEntity<Uuser> newUuser(@RequestBody Uuser_Create_Dto new_uuserDto) {

        Uuser new_uuser =_uuserService.convertDTOToUuser(new_uuserDto);   //En new_uuser guardo el Uuser convertido desde DTO.

        _uuserService.newUser(new_uuser); //Este metodo llamado desde el Service crea el User.

        return ResponseEntity.ok(new_uuser);        // Retorno un 200 con el User creado
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Uuser_Get_Dto> getById(@PathVariable Integer id) throws ResourceNotFoundException {  // En esta linea se agrega "throws ResourceNotFoundException" para devolver si hay un error.

        Uuser get_user = _uuserService.findByIdUuser(id).orElse(null);
        if (get_user == null){
            throw new ResourceNotFoundException("The user with the " + id + " has not been found");
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");   //Esto se remplaza para implementar las excepciones(línea de arriba).
        }
        Uuser_Get_Dto get_uuserDto = _uuserService.convertUuserToUuserGetDTO(get_user);   // Optimizar para saber si es nulo que devuelva un mensaje de que no lo  encontro.


        return ResponseEntity.ok(get_uuserDto);
    }

    //@GetMapping("/getAll")           //Este enpoint retorna una lista de tipo Uuser.  INUTILIZADO!
    //public ResponseEntity<List> getAllUuser() throws ResourceNotFoundException {

      // return ResponseEntity.ok(_uuserService.getAll());

    //}

    @GetMapping("/getAll")                  //Este enpoint retorna una lista de Uuser_Dto
    public ResponseEntity<List> getAllUuserDTO() throws ResourceNotFoundException {
        List<Uuser> uusers = _uuserService.getAll();
        List<Uuser_Get_Dto> uuserDTOs = uusers.stream()
                .map(uuser -> _uuserService.convertUuserToUuserGetDTO(uuser))  //Aca recorro la lista un y la convierto en dto
                .collect(Collectors.toList());              //Aca convierto la coleccion en una lista
        return ResponseEntity.ok(uuserDTOs);                // Y aca retorno la lista de tipo Uuser_dto.
    }

    @DeleteMapping("/delete/{id}")              //Este metodo solo debe estar disponible para el Admin.
    public ResponseEntity<String> deleteUuser(@PathVariable Integer id) throws ResourceNotFoundException{

        _uuserService.deletUuser(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }




}

