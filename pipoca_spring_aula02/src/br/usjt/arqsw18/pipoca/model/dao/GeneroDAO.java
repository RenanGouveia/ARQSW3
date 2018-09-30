package br.usjt.arqsw18.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;
@Repository
public class GeneroDAO {
	
	private Connection conn;
	@Autowired
	public GeneroDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		} catch (SQLException e){
			throw new IOException(e);
		}
	}
	
	public Genero buscarGenero(int id) throws IOException {
		Genero genero = null;
		String sql = "select id, nome from genero where id=?";

		try (PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery();) {

				if (rs.next()) {
					genero = new Genero();
					genero.setId(id);
					genero.setNome(rs.getString("nome"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return genero;
	}

	public ArrayList<Genero> listarGeneros() throws IOException {
		ArrayList<Genero> generos = new ArrayList<>();
		String sql = "select id, nome from genero order by nome";

		try (PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {
				Genero genero = new Genero();
				genero.setId(rs.getInt("id"));
				genero.setNome(rs.getString("nome"));
				generos.add(genero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return generos;
	}
	
	public ArrayList<Filme> listarFilmes(Genero genero) throws IOException{
		ArrayList<Filme> filmes = new ArrayList<>();
		String sql = "select * from filme where id_genero = ?";
			
			try (PreparedStatement pst = conn.prepareStatement(sql);) {
				pst.setInt(1,genero.getId());
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Filme filme = new Filme();
					filme.setId(rs.getInt("id"));
					filme.setTitulo(rs.getString("titulo"));
					filme.setDescricao(rs.getString("descricao"));
					filme.setDiretor(rs.getString("diretor"));
					filme.setPosterPath(rs.getString("posterpath"));
					filme.setDataLancamento(rs.getDate("data_lancamento"));
					filme.setPopularidade(rs.getInt("popularidade"));
					filmes.add(filme);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			return filmes;
	}
}
