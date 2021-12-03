<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Caixa"%>
<%
	Caixa caixa = (Caixa) request.getAttribute("caixa");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Banco Dinheiros</title>
<link rel="icon" href="imagens/icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<div align="center">
	<h1>Abastecimento</h1>
		<table class = "tabela">	
		<thead>
			<th><a href="adicionar" class="Botao2">Abastecer Notas</a></th>
			<th><a href="javascript: visualizarSaldo(<%= caixa.getTotal()%>, <%=caixa.getNotas10()%>, <%=caixa.getNotas20()%>, <%=caixa.getNotas50()%>, <%=caixa.getNotas100()%> )" class="Botao2">Valor em Caixa</a></th>
			<th><a href="sair" class="Botao3">Sair</a></th>
		</thead>
		</table>
		<br>
		<form name="formularioAbastecimento" action="abastecimento">
				<td><input type="number" name="notas10" placeholder="Quantidade notas de R$10,00" class = "Caixa1"></td>
				<br>
				<td><input type="number" name="notas20" placeholder="Quantidade notas de R$20,00" class = "Caixa1"></td>
				<br>
				<td><input type="number" name="notas50" placeholder="Quantidade notas de R$50,00" class = "Caixa1"></td>
				<br>
				<td><input type="number" name="notas100" placeholder="Quantidade notas de R$100,00" class = "Caixa1"></td>
				<br>
				<input type="button" value="Abastecer" class="Botao1"
				onclick="validar()">
			</form>
		
	</div>
	<script src="scripts/saldoAbastecido.js"></script>
	<script src="scripts/validadorabastecer.js"></script>

</body>
</html>