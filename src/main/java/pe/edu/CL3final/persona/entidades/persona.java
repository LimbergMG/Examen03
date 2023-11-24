package pe.edu.CL3final.persona.entidades;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class persona {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public
    Long id;
    public String nombre;
    public String apellido;
    public String dni;
     public String direccion;
     public LocalDate fechaNacimiento;
     public String email;
}
