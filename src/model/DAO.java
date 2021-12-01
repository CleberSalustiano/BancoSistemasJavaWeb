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
			System.out.println(e);
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
				login.setNome(rs.getString(2));
				login.setSaldo(rs.getInt(4));
				contador ++;
			}
			if (contador == 0) {
				login.setConta("");
				login.setSenha("");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
