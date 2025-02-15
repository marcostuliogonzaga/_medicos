package com.medicos.api.model.medico;

import lombok.AllArgsConstructor; /* coloando asterisco no import lombok ele pega todas as importações epodendo apagar para nao gerar uitas linhas */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

   private String nome;
   private String email;
   private String crm;
   private Especialidade especialidade;
   private String endereco;


    
}
