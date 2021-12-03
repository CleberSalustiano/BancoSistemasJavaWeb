/**
 * 
 */
function validar(){
	let nome = formularioCadastro.nome.value
	let conta = formularioCadastro.conta.value
	let senha = formularioCadastro.senha.value
	let csenha = formularioCadastro.repetesenha.value

	if (nome === ""){
		alert ('Preencha o campo Nome')
		formularioCadastro.nome.focus()
		return false
	}else if (conta === ""){
		alert ('Preencha o campo Conta')
		formularioCadastro.conta.focus()
		return false
	}else if (senha === ""){
		alert ('Preencha o campo Senha')
		formularioCadastro.senha.focus()
		return false
	}else if (senha != csenha){
		alert ('As senhas são diferentes')
		formularioCadastro.senha.focus()
		return false
	}else{
		document.forms["formularioCadastro"].submit()
	}
}