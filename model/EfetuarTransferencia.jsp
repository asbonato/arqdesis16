<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Caixa Eletrônico - BankLine</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/loginStyle.css" />

</head>

<body>

	<!-- Barra superior com os menus de navegação -->
	<c:import url="menu.jsp" />

	<div id="mainDiv" class="efetuarTrasnferencia">

		<div id="titleBankLine" align="center">
			<h1>Transferencia</h1>
		</div>

		<div id="tableExtractOptions" align="center">
			<form action="Controller.do" method="post">
				<table style="width: 25%">
					<tr>
						<td align="center">
							<div id="divAgency">
								<label for="labelAgency"
									style="color: #4d4d4d; font-family: courier; font-size: 110%">Agencia</label>
								<input min="0" max="999" type="number"
									class="form-control bfh-number" id="inputAgency" step="1"
									data-bind="value:inputAgency" name="data[agencia]"
									style="width: 70%; margin: -3px; border: 2px" placeholder="000"
									required>
							</div>
						</td>
						<td align="center">
							<div id=divAccount>
								<label for="inputAccount"
									style="color: #4d4d4d; font-family: courier; font-size: 110%">Conta</label>
								<input min="0" max="999" type="number"
									class="form-control bfh-number" id="inputAccount" step="1"
									data-bind="value:inputAccount" name="data[conta]"
									style="width: 70%; margin: -3px; border: 2px" placeholder="000"
									required>
							</div>
						</td>
						<td align="center">
							<div id=divValue>
								<label for="inputValue"
									style="color: #4d4d4d; font-family: courier; font-size: 110%">Valor</label>
								<input min="0" max="1000" type="number"
									class="form-control bfh-number" id="inputValue"
									data-bind="value:inputValue" name="data[valorTransf]"
									style="width: 50%; margin: -3px; border: 2px"
									placeholder="0.00" pattern="[0-9]+([\.,][0-9]+)?" step="0.01"
									required>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><br>
							<button type="submit" class="btn btn-porimary" name="command"
								value="EfetuarTransferencia">Confirma</button>
						<td>
					</tr>
				</table>
			</form>
		</div>

	</div>

	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>