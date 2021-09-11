<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cadastro de Contato</title>
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
			<div>
				<c:if test="${contato != null}">
					<form action="atualizar" method="post">
				</c:if>
				<c:if test="${contato == null}">
					<form action="inserir" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${contato != null}">Editar Contato</c:if>
						<c:if test="${contato == null}">Inserir Contato</c:if>
					</h2>
				</caption>
				<c:if test="${contato != null}">
					<input type="hidden" name="id"
						value="<c:out value='${contato.id}' />" />
				</c:if>
				<fieldset>
					<label>Telefone:</label> <input type="text"
						value="<c:out value='${contato.telefone}' />" name="telefone">
				</fieldset>
				<fieldset>
					<label>E-mail:</label> <input type="text"
						value="<c:out value='${contato.email}'/>" name="email">
				</fieldset>
				<button type="submit">Salvar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>