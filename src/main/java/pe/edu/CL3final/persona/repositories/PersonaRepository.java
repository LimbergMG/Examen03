package pe.edu.CL3final.persona.repositories;
import java.util.List;


import  pe.edu.CL3final.persona.entidades.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository  <persona, Long> {
    @Query("select pe from persona as pe where nombre like CONCAT('%',:nombre,'%')")
    List<persona> buscPersonasPorNombre(String nombre);


    //select * from where nombre = ?
     List<persona> findByNombre(String nombre);

     List<persona> readByNombre(String nombre);

     List<persona> queryByNombre(String nombre);

     List<persona> searchByNombre(String nombre);

      List<persona> searchByNombreContains(String nombre);


      @Query("select pe from persona as pe where dni like CONCAT('%',:dni,'%')")
    List<persona> buscPersonasPordni(String dni);


    //select * from where nombre = ?
     List<persona> findByDni(String dni);

     List<persona> readByDni(String dni);

     List<persona> queryByDni(String dni);

     List<persona> searchByDni(String dni);

      List<persona> searchByDniContains(String dni);

  

}