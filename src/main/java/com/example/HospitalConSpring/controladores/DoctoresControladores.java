package com.example.HospitalConSpring.controladores;

import com.example.HospitalConSpring.Servis.DoctoresServis;
import com.example.HospitalConSpring.Servis.ServisPaciente;
import com.example.HospitalConSpring.entity.Doctores;
import com.example.HospitalConSpring.repository.DoctoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DoctoresControladores {
//atributo

    private DoctoresRepository doctoresRepository;

    private DoctoresServis doctoresServis;
    private final Logger log = LoggerFactory.getLogger(DoctoresControladores.class);




    //buscar doctor
    @GetMapping("api/doctor/{especialidad}")
    public ResponseEntity<Doctores>findOneById(@PathVariable String especialidad){
        Optional<Doctores> doctorestt=doctoresRepository.findByespecialidad(especialidad);
        if(doctorestt.isPresent()){
            return ResponseEntity.ok(doctorestt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    //crear doctores
    @PostMapping("api/nuevodoctor")
    public ResponseEntity<Doctores> create(@RequestBody Doctores doc, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("usuario-headers"));
        //guardar los datos recibido por parametros
        if (doc.getId() != null){//quiere decir que el usuario del doctor ya esta creado
            log.warn("no puedes crear este usuario por que ya existe");
            return ResponseEntity.badRequest().build();
        }
        Doctores resultado = doctoresRepository.save(doc);
        return ResponseEntity.ok(resultado);
    }

    //actualizar doctores
    @PutMapping("api/doctor")
    public ResponseEntity<Doctores>  update(@RequestBody Doctores doctores){

        //guardar los datos recibido por parametros
        if (doctores.getId() == null){//quiere decir que el usuario del doctor ya esta creado
            log.warn("no puedes actualizar un usuario que no existe");
            return ResponseEntity.badRequest().build();
        }
        if(!doctoresRepository.existsById(doctores.getId())){
            log.warn("no puedes actualizar un usuario que no existe");
            return ResponseEntity.notFound().build();
        }
        Doctores resultado = doctoresRepository.save(doctores);
        return ResponseEntity.ok(resultado);
    }

    //borrar doctores
    @DeleteMapping("/api/delate/{id}")

    public ResponseEntity<Doctores> delate(@RequestBody Long id){

        if(!doctoresRepository.existsById(id)){
            log.warn("no puedes eliminar un usuario que no existe");
            return ResponseEntity.notFound().build();
        }

        doctoresRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
