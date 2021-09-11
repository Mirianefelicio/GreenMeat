<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><html>
<head>
<title>Listar Contato</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="<%=request.getContextPath()%>/listar">Contatos</a>
				</li>
			</ul>
		</nav>
	</header>
	<br>
	<div>
		<div>
			<h3>Lista De Contatos</h3>
			<hr>
			<div>
				<a href="<%=request.getContextPath()%>/novo">Adicionar Contato</a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
						<th>Telefone</th>
						<th>E-mail</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="contato" items="${contatos}">
						<tr>
							<td><c:out value="${contato.telefone}" /></td>
							<td><c:out value="${contato.email}" /></td>
							<td><a href="editar?id=<c:out value='${contato.id}'/>">Editar</a>	<a href="deletar?id=<c:out value='${contato.id}'/>">Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>