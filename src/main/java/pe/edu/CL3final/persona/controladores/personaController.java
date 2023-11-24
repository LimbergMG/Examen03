package pe.edu.CL3final.persona.controladores;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.CL3final.persona.PersonaRequest;

import  pe.edu.CL3final.persona.entidades.persona;

import lombok.AllArgsConstructor;
import pe.edu.CL3final.persona.repositories.PersonaRepository;

@RestController

@AllArgsConstructor

@RequestMapping("persona")
public class personaController {

    PersonaRepository personaRepository;
    @GetMapping
    public List<persona> listarPersona(String nombre, String dni){
        if(nombre != null){

            return personaRepository.searchByNombreContains(nombre);
        }

                if(dni != null){

            return personaRepository.searchByDniContains(dni);
        }



        
        return personaRepository.findAll();
     
    }





        @GetMapping("{id}")
   public ResponseEntity<persona> findById(@PathVariable Long id){
       
       return ResponseEntity.of(personaRepository.findById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long register(@RequestBody @Valid PersonaRequest personaRequest){
        persona persona = new persona();
       persona.nombre = personaRequest.nombre;
      persona.apellido = personaRequest.apellido;
       persona.dni = personaRequest.dni;
      persona.direccion = personaRequest.direccion;
       persona.fechaNacimiento = personaRequest.fechaNacimiento;
       persona.email = personaRequest.email;
      
       persona mascotaGuardada =  personaRepository.save(persona);  
       return mascotaGuardada.id;
    }

    @DeleteMapping("{id}")
    public  void deleteById(@PathVariable Long id){

        personaRepository.deleteById(id);;
    }
    @PutMapping("{id}")
    public ResponseEntity<persona> update(@PathVariable Long id,@RequestBody @Valid PersonaRequest personaRequest){

      Optional<persona> personaOptional= personaRepository.findById(id);
       if(personaOptional.isPresent()){
      persona persona = personaOptional.get();
   persona.nombre = personaRequest.nombre;
       persona.apellido = personaRequest.apellido;
      persona.dni = personaRequest.dni;
      persona.direccion = personaRequest.direccion;
      persona.fechaNacimiento = personaRequest.fechaNacimiento;
       persona.email = personaRequest.email;
        personaRepository.save(persona);

     return ResponseEntity.ok(persona);
      }
       return ResponseEntity.notFound().build();
    }

       @PatchMapping("{id}")
    public ResponseEntity<persona> updatePartial(@PathVariable Long id,@RequestBody @Valid PersonaRequest personaRequest){

        return personaRepository.findById(id).map(persona ->{
            if(personaRequest.nombre != null){
                persona.nombre = personaRequest.nombre;
            }

            if(personaRequest.apellido != null){
                persona.apellido = personaRequest.apellido;
            }

            if(personaRequest.dni != null){
                persona.dni = personaRequest.dni;
            }

            if(personaRequest.direccion != null){
                persona.direccion = personaRequest.direccion;
            }

            if(personaRequest.fechaNacimiento != null){
                persona.fechaNacimiento = personaRequest.fechaNacimiento;
            }
            if(personaRequest.email != null){
                persona.email = personaRequest.email;
            }
            personaRepository.save(persona);
            
            return ResponseEntity.ok(persona);
        }).orElseGet(()-> ResponseEntity.notFound().build());
    }
}
