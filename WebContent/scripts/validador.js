/**
 * 
 */
function validar(){
	let conta = formularioLogin.conta.value
	let senha = formularioLogin.senha.value
	if (conta === ""){
		alert ('Preencha o campo Conta')
		frmContato.conta.focus()
		return false
	}else if (senha === ""){
		alert ('Preencha o campo Senha')
		frmContato.senha.focus()
		return false
	} else{
		document.forms["formularioLogin"].submit()
	}
}
function validarSaque(){
	let saque = formularioSaque.saque.value
	if (saque === ""){
		alert ('Preencha o campo Saque')
		formularioSaque.saque.focus()
		return false
	} else{
		document.forms["formularioSaque"].submit()
	}
}