/**
 * 	é possível validar os campos utilizando o próprio documento HTML, este arquivo javascript
 * 	deve servir apenas como prática e possível desacoplamento de código
 */

function validar(){
	let placa = frmCarro.placa.value;
	let nome = frmCarro.nome.value;
	
	if(placa === ""){
		alert('Preencha o campo PLACA');
		frmCarro.placa.focus();
		return false;
	}
	else if(nome === ""){
		alert('Preencha o campo NOME');
		frmCarro.nome.focus();
		return false;
	}
	else{
		document.forms["frmCarro"].submit();
	}
}
 