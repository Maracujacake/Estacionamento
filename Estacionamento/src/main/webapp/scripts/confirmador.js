/**
 * 
 */

 function confirmar(idCarro){
	let resposta = confirm("Confirma a exclusão?");
	if(resposta === true){
		window.location.href= "delete?idCarro=" + idCarro;
	}
 }
 
 // exibe quantas horas e minutos o registro está presente
 function gerarHorario(horaChegada){
    let chegada = new Date(horaChegada);
    let agora = new Date();

    let diferenca = agora - chegada;

    let minutos = Math.floor(diferenca / (1000 * 60));
    let horas = Math.floor(minutos / 60);

    minutos = minutos % 60;

    // Exibindo o resultado
    let resultado = `Tempo decorrido: ${horas} horas, e ${minutos} minutos.`;
    alert(resultado);
 }