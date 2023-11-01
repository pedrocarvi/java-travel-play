package com.app.tap.service;

import com.app.tap.entitites.Uuser;
import com.app.tap.entitites.dto.Uuser_Create_Dto;
import com.app.tap.entitites.dto.Uuser_Get_Dto;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.repository.UuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UuserService {

    @Autowired
    UuserRepository _uuserRepository;


    public Uuser newUser(Uuser _uuser){
      return _uuserRepository.save(_uuser);//Retorno directamente el metodo .save desde repository creando el User con _uuser

    }

    public Optional<Uuser> findById(Integer id) {
        return _uuserRepository.findById(Long.valueOf(id));
    }

    public List<Uuser> getAll() {                    // Con esto devuelvo uno lista con todos los Uusers de la Db.
        return _uuserRepository.findAll();
    }


    public Uuser convertDTOToUuser(Uuser_Create_Dto _uuser_create_dto){          // Este metodo sirve para mapear el User Dto a User para poder guardarlo en la base de datos.
                                                            // Esto lo utilizo para crear un Uuser.
        Uuser uuser = new Uuser();

        uuser.setUserName(_uuser_create_dto.getUserName());            //Seteo todas las propiedades del Dto en el user
        uuser.setFirstName(_uuser_create_dto.getFirstName());
        uuser.setPssword(_uuser_create_dto.getPssword());
        uuser.setLastName(_uuser_create_dto.getLastName());
        uuser.setEmail(_uuser_create_dto.getEmail());

        return uuser;                       //Por ultimo retorno el User ya mapeo de DTO.
    }

    public Uuser_Get_Dto convertUuserToUuserGetDTO(Uuser _uuser){
        Uuser_Get_Dto uuser_get_dto = new Uuser_Get_Dto();

                                                     // Esto lo uso para devolver la entidad Uuser sin datos sensibles
        uuser_get_dto.setId(_uuser.getUserId());
        uuser_get_dto.setUserName(_uuser.getUserName());
        uuser_get_dto.setFirstName(_uuser.getFirstName());
        uuser_get_dto.setLastName(_uuser.getLastName());
        uuser_get_dto.setEmail(_uuser.getEmail());



        return uuser_get_dto;


    }

    public void deletUuser(Integer id)throws ResourceNotFoundException{
        if(findById(id).isEmpty())
            throw new ResourceNotFoundException("No existe el usuario con el id: "+id);

        Uuser del_Uuser = _uuserRepository.findById(Long.valueOf(id)).orElse(null);

        _uuserRepository.delete(del_Uuser);


    }
}
