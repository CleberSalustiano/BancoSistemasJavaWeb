<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Pessoa"%>
<%
	Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
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
	<h1>Seja bem vindo, <%=pessoa.getNome() %></h1>
		<table class = "tabela">
		<thead>
			<th><a href="saque" class="Botao2">Sacar</a></th>
			<th><a href="javascript: visualizarSaldo(<%= pessoa.getSaldo()%>)" class="Botao2">Saldo</a></th>
			<th><a href="conta" class="Botao2">Conta</a></th>
			<th><a href="sair" class="Botao3">Sair</a></th>
		</thead>
		</table>
		<br>
			<form name="formularioSaque" action="sacar">
				<td><input type="number" name="saque" placeholder="Digite o valor do saque" class = "Caixa2"></td>
				<input type="button" value="sacar" class="Botao1"
				onclick="validar()">
			</form>
	</div>
	<script src="scripts/validadorsaque.js"></script>
	<script src="scripts/saldo.js"></script>
	
	
</body>
</html>