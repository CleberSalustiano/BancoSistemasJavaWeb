package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/bancosistema?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "mypass";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			//System.out.println(e);
			return null;
		}
	}

	public void confereLogin(Pessoa login) {
		String read = "select * from login where conta = ? and senha = ?";
		int contador = 0;
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, login.getConta());
			pst.setString(2, login.getSenha());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				login.setId(rs.getInt(1));
				login.setNome(rs.getString(2));
				login.setSaldo(rs.getInt(5));
				contador++;
			}
			if (contador == 0) {
				login.setConta("");
				login.setSenha("");
			}
			//System.out.println(login.getNome());
			con.close();
		} catch (Exception e) {
			//System.out.println(e);
		}
	}

	public void setaCaixa(Caixa caixa) {
		String read = "select * from Caixa where id=1";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				caixa.setNotas10(Integer.parseInt(rs.getString(2)));
				caixa.setNotas20(Integer.parseInt(rs.getString(3)));
				caixa.setNotas50(Integer.parseInt(rs.getString(4)));
				caixa.setNotas100(Integer.parseInt(rs.getString(5)));
			}
			con.close();
			caixa.setTotal();
		} catch (Exception e) {
			//System.out.println(e);
		}

	}

	public void atualizaCaixa(Caixa caixa) {
		String update = "update Caixa set notas10=?, notas20=?, notas50=? ,notas100=? where id=1";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setInt(1, caixa.getNotas10());
			pst.setInt(2, caixa.getNotas20());
			pst.setInt(3, caixa.getNotas50());
			pst.setInt(4, caixa.getNotas100());
			pst.executeUpdate();
			con.close();
			caixa.setTotal();
		} catch (Exception e) {
			//System.out.println(e);
		}

	}

	public void atualizaSaldo(Pessoa login) {
		String update = "update login set saldo=? where idlogin=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setInt(1, login.getSaldo());
			pst.setInt(2, login.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			//System.out.println(e);
		}
	}

	public void confereAbastecer(Pessoa login) {
		String read = "select * from login where idlogin=3";
		int contador = 0;
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				if (login.getConta().equals(rs.getString(3)) && login.getSenha().equals(rs.getString(4))) {
					login.setId(rs.getInt(1));
					login.setNome(rs.getString(2));
					login.setSaldo(rs.getInt(5));
				}contador ++;
			}
			//System.out.println(contador);
			con.close();
		} catch (Exception e) {
			//System.out.println(e);
		}
	}

	public void cadastraUsuario(Pessoa login) {
		String create = "insert into login (nome,conta,senha,saldo) values (?,?,?, 2000)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, login.getNome());
			pst.setString(2, login.getConta());
			pst.setString(3, login.getSenha());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			//System.out.println(e);
		}
	}

	public void atualizaUsuario(Pessoa login) {
		String update =  "update login set nome=?,conta=?,senha=? where idlogin=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, login.getNome());
			pst.setString(2, login.getConta());
			pst.setString(3, login.getSenha());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			//System.out.println(e);
		}
	}

	public boolean comparaLogin(Pessoa login) {
		String read = "select * from login";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if (login.getConta().equals(rs.getString(3)) && login.getSenha().equals(rs.getString(4))) {
					return false;
				}else if (login.getConta().equals(rs.getString(3))) {
					return false;
				}
			}
			con.close();
			return true;
		} catch (Exception e) {
			//System.out.println(e);
			return false;
		}
		
	}
}
