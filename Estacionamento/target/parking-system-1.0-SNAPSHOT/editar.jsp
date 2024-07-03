<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Editar</title>
</head>
<body> <!-- formulário de edição de registro -->
	<div class="painel-principal">
		<img class="imagem-agenda" alt="agenda" src="imagens/agenda.png">
		<h1 class="titulo">Editar registro</h1>
		<form name="frmCarro" action="update">
			<table>
				<tr>
					<td> Placa: <input class="input1" type="text" name="placa" value="<%out.print(request.getAttribute("placa"));%>"> </td>
				</tr> <!-- placa -->
				<tr>
					<td> Nome: <input class="input1" type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"> </td>
				</tr> <!-- nome -->
				<tr>
					
					<td> <p>Telefone: </p> <input class="input2" type="text" name="telefone" value="<%out.print(request.getAttribute("telefone"));%>"> </td>
				</tr> <!-- telefone -->
			</table>
			
			<input class="botao" type="button" value="Salvar" onclick="validar()">
		</form>
	</div>	
	
	<script type="text/javascript" src="scripts/validador.js"></script>
</body>
</html>