package com.medicos.api.model.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {

     private String logradouro;
     private String bairro;
     private String cep;
     private String cidade;
     private String uf;
     private String numero;
     private String complemento;
    
}
