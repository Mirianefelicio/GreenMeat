<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 

 <div class="txt"><h2>Seus Pedidos</h2></div>

 

<table>
  <tr>
    <th>Nome do produto</th>
    <th>Preço</th>
    <th>Unidades</th>
       
  </tr>
  
  <c:forEach var="contato" items="${item}"></c:forEach>
  <tr>
    <td><c:out value="${item.pedidos.produto.nome}" /></td>
       <td><c:out value="${item.pedidos.produto.preco}" />    </td>
    <th><c:out value="${item.pedidos.produto.quantidade}" /></td>
  </tr>
 
</table>

 

 

</body>
</html>