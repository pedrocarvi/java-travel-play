package com.app.tap.controllers;

import com.app.tap.entitites.Uuser;
import com.app.tap.entitites.dto.Uuser_Dto;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.service.UuserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UuserController {

    @Autowired
    UuserService _uuserService;

    @PostMapping("/create")
    public ResponseEntity<Uuser> newUuser(@RequestBody Uuser_Dto new_uuserDto) {

        Uuser new_uuser =_uuserService.convertDTOToUuser(new_uuserDto);   //En new_uuser guardo el Uuser convertido desde DTO.

        _uuserService.newUser(new_uuser); //Este metodo llamado desde el Service crea el User.

        return ResponseEntity.ok(new_uuser);        // Retorno un 200 con el User creado
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Uuser_Dto> getById(@PathVariable Integer id) throws ResourceNotFoundException {  // En esta linea se agrega "throws ResourceNotFoundException" para devolver si hay un error.

        Uuser get_user = _uuserService.findById(id).orElse(null);
        if (get_user == null){
            throw new ResourceNotFoundException("Usuario no encontrado");
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");   //Esto se remplaza para implementar las excepciones(línea de arriba).
        }
        Uuser_Dto get_uuserDto = _uuserService.convertUuserToUuserDTO(get_user);   // Optimizar para saber si es nulo que devuelva un mensaje de que no lo  encontro.


        return ResponseEntity.ok(get_uuserDto);
    }
    @GetMapping("/getAll")           //Este enpoint retorna una lista de tipo Uuser.
    public ResponseEntity<List> getAllUuser() throws ResourceNotFoundException {

       // return ResponseEntity.ok(_uuserService.getAll());

        List<Uuser>UuserList = _uuserService.getAll();








    }

    @DeleteMapping("/delete/{id}")              //Este metodo solo debe estar disponible para el Admin.
    public ResponseEntity<String> deleteUuser(@PathVariable Integer id) throws ResourceNotFoundException{

        _uuserService.deletUuser(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");


    }


}

