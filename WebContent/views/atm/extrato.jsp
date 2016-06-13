<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" style="">

<head>
<title>Consultar Extrato</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
<script>
	function seteDias(){
		document.location.href = "${pageContext.request.contextPath}/extrato";
	}
	
	function quinzeDias(){
		document.location.href = "${pageContext.request.contextPath}/extrato?periodo=15";
	}
	
	
</script>

<script type="text/javascript">
        var records = "${movimentos}";
        var recordsPerPage = 10;
        var pages = Math.ceil(records / recordsPerPage);
        $('.sync-pagination').twbsPagination({
            totalPages : pages,
            visiblePages : 7,
            onPageClick : function(event, page) {
                $('#products').html(changePage(page));
            }
        });

        function changePage(page) {
            pnumber = page || 1;

            $.ajax({
                type : 'GET',
                dataType : 'json',
                url : 'extrato/movimentos?pagina=' + pnumber,
                success : function(products) {
                    var template = $('#products-template').html();
                    var info = Mustache.render(template, products);
                    $('#products').html(info);
                }
            })
        }
  
        //Add this in here
        changePage();
    </script>
</head>

<body>



	<div class="container">

		<h1>BEM VINDO!</h1>
		<div class="list-group">
			<!-- Current User -->
			<a href="#" class="list-group-item">
				<h4>
					<strong>Extrato</strong>
				</h4>
				
				
					<label class="radio-inline"><input type="radio"
						name="optradio" onclick="seteDias()">7 dias</label> <label class="radio-inline"><input
						type="radio" name="optradio" onclick="quinzeDias()">15 dias</label> <label
						class="radio-inline"><input type="radio" name="optradio">Outro
							periodo:</label>
				
			</a>

			<!-- Summary -->
			<a href="#" class="list-group-item">
				<h4>
					<strong>Extrato</strong>
				</h4>
				<p>
					<div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Número movimento</th>
									<th>Valor Operação</th>
									<th>Data Movimento</th>
									<th>Tipo Operação</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${movimentos}" var="movimento">
									<tr>
										<td>${movimento.idMov}</td>
										<td>${movimento.valorOperacao}</td>
										<td>${movimento.dataMovimento}</td>
										<td>${movimento.tipoOperacao}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</p>
			</a>

			<div align="center">

				<ul class="pagination">
					<li><a href="#" onclick="changePage()">1</a></li>
					<li><a href="#" onclick="changePage()">2</a></li>
					<li><a href="#" onclick="changePage()">3</a></li>
					<li><a href="#" onclick="changePage()">4</a></li>
					<li><a href="#" onclick="changePage()">5</a></li>
				</ul>
			</div>

			<!-- Logout -->
			<a href="#" class="list-group-item">
			  <p align="right">	
				<button type="button" class="btn btn-default btn-lg"
					onclick="logout()">Logout</button>
			  </p>
			</a>
		</div>
	</div>
	
</body>
</html>