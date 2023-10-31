package com.app.tap.service;

import com.app.tap.entitites.Uuser;
import com.app.tap.entitites.dto.Uuser_Dto;
import com.app.tap.exceptions.ResourceNotFoundException;
import com.app.tap.repository.UuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

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


    public Uuser convertDTOToUuser(Uuser_Dto _uuser_dto){          // Este metodo sirve para mapear el User Dto a User para poder guardarlo en la base de datos.
                                                            // por lo general lo utilizo para guardar datos
        Uuser uuser = new Uuser();

        uuser.setUserName(_uuser_dto.getUserName());            //Seteo todas las propiedades del Dto en el user
        uuser.setFirstName(_uuser_dto.getFirstName());
        uuser.setPssword(_uuser_dto.getPssword());
        uuser.setLastName(_uuser_dto.getLastName());
        uuser.setEmail(_uuser_dto.getEmail());

        return uuser;                       //Por ultimo retorno el User ya mapedo de DTO.
    }

    public Uuser_Dto convertUuserToUuserDTO(Uuser _uuser){
        Uuser_Dto uuser_dto = new Uuser_Dto();
                                                                // Por lo general lo utilizo para devolver datos.
        uuser_dto.setUserName(_uuser.getUserName());
        uuser_dto.setFirstName(_uuser.getFirstName());
        uuser_dto.setLastName(_uuser.getLastName());
        uuser_dto.setEmail(_uuser.getEmail());

        return uuser_dto;


    }

    public void deletUuser(Integer id)throws ResourceNotFoundException{
        if(findById(id).isEmpty())
            throw new ResourceNotFoundException("No existe el usuario con el id: "+id);

        Uuser del_Uuser = _uuserRepository.findById(Long.valueOf(id)).orElse(null);

        _uuserRepository.delete(del_Uuser);


    }
}
