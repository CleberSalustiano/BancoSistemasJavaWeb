/**
 * 
 */
function validar(){
	let nome = formularioConta.nome.value
	let conta = formularioConta.conta.value
	let senha = formularioConta.senha.value

	if (nome === ""){
		alert ('Preencha o campo Nome')
		formularioConta.nome.focus()
		return false
	}else if (conta === ""){
		alert ('Preencha o campo Conta')
		formularioConta.conta.focus()
		return false
	}else if (senha === ""){
		alert ('Preencha o campo Senha')
		formularioConta.senha.focus()
		return false
	}else{
		document.forms["formularioConta"].submit()
	}
}