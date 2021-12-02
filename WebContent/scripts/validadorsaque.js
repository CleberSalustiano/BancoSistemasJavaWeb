/**
 * 
 */
function validar(){
	let saque = formularioSaque.saque.value
	if (saque === ""){
		alert ('Preencha o campo Saque')
		formularioSaque.saque.focus()
		return false
	} else{
		document.forms["formularioSaque"].submit()
	}
}