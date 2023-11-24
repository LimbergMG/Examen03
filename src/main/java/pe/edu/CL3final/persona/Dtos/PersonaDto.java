package pe.edu.CL3final.persona.Dtos;

import java.time.LocalDate;

public class PersonaDto {


    public  String nombre;
    public  String apellido;
    public  String dni;
    public  String direccion;
    public  LocalDate fechaNacimiento;
    public String email;
  
    public PersonaDto(String nombre,
  String apellido,
      String dni,
     String direccion,
      LocalDate fechaNacimiento,
     String email){
      this.nombre = nombre;
      this.apellido = apellido;
      this.dni = dni;
      this.direccion = direccion;
      this.fechaNacimiento = fechaNacimiento;
      this.email = email;
}
}