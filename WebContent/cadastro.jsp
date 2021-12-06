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
		<h1>Cadastro</h1>
		<%
			if (resposta != null) {
		%>
		<a class="senhaIncorreta"><%=resposta%></a>
		<%
			}
		%>
		<form name="formularioCadastro" action="cadastrar">
			<table>
				<tr>
					<td><input type="text" name="nome" placeholder="Nome"
						class="Caixa1"></td>
				</tr>
				<tr>
					<td><input type="text" name="conta" placeholder="Conta"
						class="Caixa1"></td>
				</tr>
				<tr>
					<td><input type="password" name="senha" placeholder="Senha"
						class="Caixa1"></td>
				</tr>
				<tr>
					<td><input type="password" name="repetesenha"
						placeholder="Confirme a Senha" class="Caixa1"></td>
				</tr>
			</table>
			<input type="button" value="Cadastrar" class="Botao1"
				onclick="validar()">
		</form>
		<script src="scripts/validadorCadastro.js"></script>
	</div>

</body>
</html>