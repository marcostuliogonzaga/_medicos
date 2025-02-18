package com.medicos.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/olamundo") //Informa qual será o end point acessado que vai chamar a classe "olá mundo"
@RestController // INFORMA AO SPRING BOOT QUE A CLASSE OlaMundo é uma classe do tipo controladora

public class OlaMundo {

    @GetMapping //iNFORMA QUE O METODO SERÁ INVOCADO QUANDO UM GET ACONTECER
    public String olaMundo(){
        return "Olá Mundo";
    }

}


// END POINT
// localhost:8080 ( Como se fosse a pagina principal)
// localhost:8080/medicos
// localhost:8080/pacientes
// localhost:8080/pacientes/consultas
// localhost:8080/olamundo