package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/Estacionamento?useTimezone=true&serverTimezone=UTC";
	private String user = "chris";
	private String password = "1234";
	
	private Connection conectar() {
		Connection c = null;
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url,user,password);
			System.out.println("Conexao bem sucedida");
			return c;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void testeConexao() {
		try {
			Connection c = conectar();
			c.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insereCarroNoBanco(JavaBeans Informacoes) {
		String create = "insert into Cliente (Nome, Telefone) values (?,?)";
		String create2 = "insert into Carros (Placa, idCliente, horaChegada) values (?,?,?)";
		try {
			// adiciona em clientes
			Connection c = conectar();
			PreparedStatement pst = c.prepareStatement(create);
			pst.setString(1, Informacoes.getNome());
			pst.setString(2, Informacoes.getTelefone());
			
			pst.executeUpdate();
			
			// adiciona em carros
			pst = c.prepareStatement(create2);
			pst.setString(1, Informacoes.getPlaca());
			pst.setString(2, Informacoes.getIdCliente());
			Timestamp horaAtual = Timestamp.valueOf(LocalDateTime.now());
			pst.setTimestamp(3, horaAtual);
			
			pst.executeUpdate();
			
			c.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<JavaBeans> listaRegistros(){
		ArrayList<JavaBeans> registros = new ArrayList<>();
		String query = "SELECT a.Nome, a.Telefone, b.placa, b.idCarro, b.horaChegada FROM Cliente a JOIN Carros b ON a.idCliente = b.idCarro";
		
		try {
			Connection c = conectar();
			PreparedStatement pst = c.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String Nome = rs.getString(1);
				String Telefone = rs.getString(2);
				String placa = rs.getString(3);
				String idCarro = String.valueOf(rs.getInt(4));
				String horaChegada = String.valueOf(rs.getTimestamp(5));
				
				registros.add(new JavaBeans(idCarro, "", placa, Nome, Telefone, horaChegada,
		"", "", ""));
			}
			
			// retorno do array
			c.close();
			return registros;
		} 
		
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void selecionar(JavaBeans Informacoes) {
		String sequel = "select a.nome, a.telefone, b.placa from Cliente a JOIN Carros b ON a.idCliente = b.idCarro where b.idCarro = ?";
		try {
			Connection c = conectar();
			PreparedStatement pst = c.prepareStatement(sequel);
			pst.setString(1, Informacoes.getIdCarro());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Informacoes.setNome(rs.getString(1));
				Informacoes.setTelefone(rs.getString(2));
				Informacoes.setPlaca(rs.getString(3));
			}
			c.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterar(JavaBeans Informacoes) {
		String create = "update Cliente set Nome = ?, Telefone = ? where idCliente = ?";
		String create2 = "update Carros set placa = ? where idCarro = ?";
		try {
			Connection c = conectar();
			PreparedStatement pst = c.prepareStatement(create);
			pst.setString(1, Informacoes.getNome());
			pst.setString(2, Informacoes.getTelefone());
			pst.setString(3, Informacoes.getIdCarro());
			pst.executeUpdate();
			
			pst = c.prepareStatement(create2);
			pst.setString(1, Informacoes.getPlaca());
			pst.setString(2, Informacoes.getIdCarro());
			pst.executeUpdate();
			
			c.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteInfo(JavaBeans Informacoes) {
		String delete = "delete from Cliente where idCliente = ?";
		String delete2 = "delete from Carros where idCarro = ?";
		try {
			Connection c = conectar();
			PreparedStatement pst = c.prepareStatement(delete);
			pst.setString(1, Informacoes.getIdCarro());
			pst.executeUpdate();
			
			pst = c.prepareStatement(delete2);
			pst.setString(1, Informacoes.getIdCarro());
			pst.executeUpdate();
			
			c.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
