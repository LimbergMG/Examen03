package pe.edu.CL3final.persona;

import java.time.LocalDate;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Setter;

@Setter
public class PersonaRequest {
   public
    Long id;
    @NotBlank
    public String nombre;
    @NotBlank
    public String apellido;
    @Digits(integer=8,fraction = 8)
    public String dni;
     @NotBlank
     public String direccion;
     @Past
     public LocalDate fechaNacimiento;
     @Email
     public String email;
}
