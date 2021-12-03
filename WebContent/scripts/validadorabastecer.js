/**
 * 
 */
function validar(){
	let notas10 = formularioAbastecimento.notas10.value
	let notas20 = formularioAbastecimento.notas20.value
	let notas50 = formularioAbastecimento.notas50.value
	let notas100 = formularioAbastecimento.notas100.value

	if (notas10 === ""&& notas20 === "" && notas50 =="" && notas100 ==""){
		alert ('Preencha algum campo')
		return false
	} else{
		document.forms["formularioAbastecimento"].submit()
	}
}