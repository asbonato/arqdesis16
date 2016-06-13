<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>Caixa eletrônico</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container" style="width:500px;">
		<h2>Insira seus dados para para logar:</h2>
		
		<form role="form" method="post" action="${pageContext.request.contextPath}/authentication">
			<div class="form-group">
				<label for="conta">Conta:</label>
				<input type="text" class="form-control" name="conta" id="conta" placeholder="Insira sua conta" autocomplete="on" autofocus="true" required />
			</div>
			<!-- Login -->
			<div class="form-group">
				<label for="agencia">Agência:</label>
				<input type="text" class="form-control" name="agencia" id="agencia" placeholder="Insira sua agencia" autocomplete="on" autofocus="true" required />
			</div>
			<!-- Password -->
			<div class="form-group">
				<label for="senha">Senha</label>
				<input type="password" class="form-control" name="senha" id="senha" placeholder="Insira sua senha" required/>
			</div>
			<!-- Send this form to server -->
			<div class="form-group" align="center">
				<button type="submit" class="btn btn-default btn-lg">
					Entrar
				</button>
				<button type="reset" class="btn btn-default btn-lg">
					Cancelar
				</button>
			</div>
		</form>
	</div>
</body>
</html>