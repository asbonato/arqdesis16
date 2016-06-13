<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Saque</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>

<body>
	<div class="container">

		<div>
			<h1 align="center">
				<strong>Valores disponíveis:</strong>
			</h1>
		</div>
		<form role="form" method="post"
			action="${pageContext.request.contextPath}/saque">
			<div class="form-group" align="center">
				<button class="btn btn-default btn-lg" name="valor"
					value="10">R$ 10</button>
				<button class="btn btn-default btn-lg" name="valor"
					value="20">R$ 20</button>
				<button class="btn btn-default btn-lg" name="valor"
					value="50"">R$ 50</button>
				<div>
					<button class="btn btn-default btn-lg" name="valor"
						value="100">R$ 100</button>
					<button class="btn btn-default btn-lg" name="valor"
						value="200">R$ 200</button>
					<button class="btn btn-default btn-lg" name="valor"
						value="500">R$ 500</button>

				</div>
			</div>
		</form>
	</div>
</body>
</html>