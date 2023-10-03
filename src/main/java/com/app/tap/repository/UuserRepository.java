package com.app.tap.repository;

import com.app.tap.entitites.Uuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UuserRepository extends JpaRepository<Uuser,Long> {

    //En el repository no hay nada hardcoeado ya uso los metodos extendidos de JPARepository para usarlos en el service.

}
