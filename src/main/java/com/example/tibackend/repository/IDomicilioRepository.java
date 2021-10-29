package com.example.tibackend.repository;

import com.example.tibackend.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {

    @Query("from Domicilio d where d.localidad like %:localidad%")
    Set<Domicilio> getDomicilioByLocalidadLike(@Param("localidad")String localidad);
}
