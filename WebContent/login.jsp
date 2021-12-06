<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String resposta = (String) request.getAttribute("resposta");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Banco Dinheiros</title>
<link rel="icon" href="imagens/icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<img src="imagens/banco.png">
		<h1>LOGIN</h1>
		<form name="formularioLogin" action="login">
			<table>
				<tr>
					<%
						if (resposta != null) {
					%>
					<a class="senhaIncorreta"><%=resposta%></a>
					<%
						}
					%>
				</tr>
				<tr>
					<td><input type="text" name="conta" placeholder="Conta"
						class="Caixa1"></td>
				</tr>
				<tr>
					<td><input type="password" name="senha" placeholder="Senha"
						class="Caixa1"></td>
				</tr>
			</table>
			<input type="button" value="Entrar" class="Botao1"
				onclick="validar()"> <a href="cadastro" class="Botao4">Cadastro</a>
		</form>
		<script src="scripts/validador.js"></script>
	</div>

</body>
</html>