# Arquivos desenvolvidos até o momento:
1. [ConfiguracoesSeguranca] -> Nessa classe, estamos mapeando em memória todos os nossos usuários.
2. [SecurityConfig] -> Classe onde estamos trabalhando com a alteração da página de login e da logout. Além disso, estamos deixando a página `home` acessível por qualquer pessoa, mesmo não estando logada.

3. [templates/login/login.html] e [cadastro.html] -> Arquivos que são referente as telas de login e de cadastro do consulta.me.

4. [SiteController] -> Controlador resposável pelas páginas globais do site.

========================================================================================

## AUTENTICAÇÃO
[Login]
1. Quando criamos nosso login, é necessário ter o campo name="username" e name="password" nos forms, para que o Spring enteda que estamos querendo sobrescrever o login que vem por padrão pelo Security.


[Logout]
2. Para que o logout seja concluído, teremos que ter uma rota para o logout. Para isso, vamos utilizar um botão. O endpoint já vem por padrão pelo Security.
Precisamos incluir o filtro de logout na classe ConfiguracoesSeguranca.java.
Adicionei um botão para o logout no index.html:
 <form th:action="@{/logout}" method="post">
    <button class="btn-link">Logout</button>
</form>

[Sessoes]
3. Importante para que saibamos qual é o usuário que está logado. `VER PRINT`.
`JSESSIONID` -> Sessão do Java.
A duração padrão da sessão é de 30 minutos.
Fazer o exemplo de pegar o JSESSIONID e colocar em um novo navegador.
`HIJACKING` - Ataque de pegar o JSESSIONID.

[Remembeme]
4. Para deixar o cookie salvo, já que se fechar o navegador o cokkie será invalidado,
iremos precisar usar o cookie remembe-me. Para isso, vamos na classe ConfiguracoesSeguranca.java e incluir esse filtro.
.rememberMe(rememberMe -> rememberMe.key("chave-segura"))
Em seguida, iremos precisar incluir no nosso login.html uma opção para que o usuário deixe selecionado a opção de lembrar dados.


===========================================================================
## Alterações para serem realizadas no dia 30/04/2025
[style.css] -> Alterar a classe `logo img` de 120px para 90px, para que possa ficar menor.
[login.html] -> Pegar esse arquivo e pedir para o gpt me explicar linha a linha o que acontece.
