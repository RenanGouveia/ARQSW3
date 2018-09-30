package br.usjt.arqsw18.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.entity.Usuario;
@Repository
public class UsuarioDAO {
	private Connection conn;
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		} catch (SQLException e){
			throw new IOException(e);
		}
	}

	public Usuario loginUsuario(Usuario usuario) throws IOException {
		Usuario user = new Usuario();
		String sql = "select usuario, senha from usuario where usuario=? and senha =? ";
		System.out.print(sql);
		try (PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, usuario.getUsuario());
			pst.setString(2, usuario.getSenha());
			try (ResultSet rs = pst.executeQuery();) {
				System.out.println("DAO " + usuario);
				if (rs.next()) {
					user.setUsuario(rs.getString("usuario"));
					user.setSenha(rs.getString("senha"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return user;
	}
}
