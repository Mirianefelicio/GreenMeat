<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!DOCTYPE html>
  <head>
    <meta charset="UTF-8" />
    <title>Formul�rio de Login e Registro com HTML5 e CSS3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  <body>
    <div class="container" >
      <a class="links" id="paracadastro"></a>
      <a class="links" id="paralogin"></a>
      </div>
      
        <!--FORMUL�RIO DE CADASTRO-->
        <div id="cadastro">
          <form method="post" action=""> 
            
             <h1>Cadastre-se</h1>
              <p> 
              <label for="nome_cad"> Raz�o Social</label>                                                           
              <input id="nome_cad" name="nome_cad" required="required" type="text" placeholder="raz�o social" />
            </p>

            <p> 
              <label for="nome_cad"> Nome Fantasia </label>                                                           
              <input id="nome_cad" name="nome_cad" required="required" type="text" placeholder="nome fantasia" />
            </p>

            <p> 
              <label for="cnpj_cad"> CNPJ</label>
              &nbsp; &nbsp; &nbsp; &nbsp;<input id="cnpj_cad" name="cnpj_cad" required="required" type="text" placeholder="CNPJ" />
            </p>
             
            <p> 
              <label for="email_cad"> E-mail</label>
              &nbsp; &nbsp; <input id="email_cad" name="email_cad" required="required" type="email" placeholder="contato@gmail.com"/> 
            </p>

            <p> 
              <label for="telefone_cad"> Telefone</label>
              &nbsp;<input id="telefone_cad" name="telefone_cad" required="required" type="text" placeholder="telefone" />
            </p>

            <p> 
              <label for="endere�o_cad"> Endere�o</label>
              <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="Nome Da Rua" />
              <br>
                
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="Tipo Da Via" />  
                <br>
               
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="Logradouro" /> 
                <br>
                 
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="N�mero" /> 
                 <br>
                 
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="Cep" /> 
              <br>
              
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="Complemento" />  
              <br>
              
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="Pa�s" />  
              <br>
             
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="estado" /> 
              <br>
               
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="provincia" /> 
               <br>
                
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input id="endere�o_cad" name="endere�o_cad" required="required" type="text" placeholder="Continente" />
                <br>
            </p>

            <p> 
              <label for="senha_cad">Crie um Login</label>
              <input id="senha_cad" name="senha_cad" required="required" type="password" placeholder="login"/>
            </p>

            <p> 
              <label for="senha_cad">Crie uma senha</label>
              <input id="senha_cad" name="senha_cad" required="required" type="password" placeholder="ex. 1234"/>
            </p>
             
            <p> 
              <input type="submit" value="Cadastrar"/> 
            </p>
             
            <p class="link">  
              J� tem conta?
              <a href="#paralogin"> Ir para Login </a>
            </p>
            
          </form>
        </div>
      </div>
    </div>  
</body>
</html>