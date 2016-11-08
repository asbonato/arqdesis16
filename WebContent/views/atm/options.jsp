<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Menu de opções</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href='<html:rewrite page="/css/login.css"/>' rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script>
	function extrato() {
		document.location.href = "${pageContext.request.contextPath}/views/atm/extrato.jsp";
	}

	function saque() {
		document.location.href = "${pageContext.request.contextPath}/views/atm/saque.jsp";
	}
</script>
</head>

<body class="body">
	<div class="list-group" align="center">

		<c:if test="${sucesso }">
			<div class="alert alert-success" role="alert">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Atenção!</strong> Saque efetuado com sucesso!
			</div>
		</c:if>

		<div class="panel panel-primary">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h1>
						<strong>Caixa eletrônico</strong>
					</h1>
				</div>
				<div class="panel-footer">
					<h1>Bem vindo ${cliente.nome}!</h1>
				</div>
				<div class="panel-footer">
					<h1 align="center">Clique no botão desejado para realizar a
						operação</h1>
				</div>

				<div class="panel-footer" align="center">
					<button type="button" class="btn btn-default btn-lg"
						onclick="extrato()">Extrato</button>
					<button type="button" class="btn btn-default btn-lg"
						onclick="saque()">Saque</button>
				</div>
				<div class="panel-footer" align="center">
					<button type="button" class="btn btn-default btn-lg"
						onclick="logout()">Sair</button>
				</div>


			</div>
		</div>
	</div>

</body>
</html>