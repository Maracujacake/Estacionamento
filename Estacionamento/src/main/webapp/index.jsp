<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<!-- Importa a lista de registros salvos no banco de dados -->
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("registros");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Estacionamento</title>
</head>
<body>
	<div class="painel-principal">
		<img class="imagem-agenda" alt="agenda" src="imagens/agenda.png">
		<h1 class="titulo">Estacionamento:</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Placa</th>
					<th>Telefone</th>
					<th>idCarro</th>
					<th>Hora de Chegada</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i = 0; i < lista.size(); i++) { %>
				
					<tr>
						<td> <%=lista.get(i).getNome() %> </td>
						<td> <%=lista.get(i).getPlaca() %> </td>
						<td> <%=lista.get(i).getTelefone() %> </td>
						<td> <%=lista.get(i).getIdCarro() %> </td>
						<td> <%=lista.get(i).getHoraChegada() %> </td>
						<td> 
							<a class="botao" style="display: block;" href="select?idCarro=<%=lista.get(i).getIdCarro() %>" >Editar</a>
							<a class="botaoGerarHorario" style="display: block;" href="javascript:gerarHorario('<%=lista.get(i).getHoraChegada() %>')" >Gerar Horário</a>
							<a class="botaoExcluir" style="display: block;" href="javascript: confirmar(<%=lista.get(i).getIdCarro() %>)" >Excluir</a>
						</td>
					</tr>
				
				<%	} %>
			</tbody>
		</table>
		<a class="botao" href="formulario.html">Adicionar carro</a>
	</div>
	<script type="text/javascript" src="scripts/confirmador.js"></script> <!-- Confirma a exclusão de um registro (botão excluir) -->
	
</body>
</html>