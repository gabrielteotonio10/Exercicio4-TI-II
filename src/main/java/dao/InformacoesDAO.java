package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Informacoes;

public class InformacoesDAO extends DAO {
	
	public InformacoesDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Informacoes info) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO agendamentos (nome, descricao, data, hora) " +
					"VALUES ('" + info.getNome() + "', '" + info.getDescricao() + "', '" +
					info.getData() + "', '" + info.getHora() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	
	public List<Informacoes> getAll() {
		List<Informacoes> infos = new ArrayList<>();
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM agendamentos ORDER BY data, hora";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Informacoes info = new Informacoes(
					rs.getString("nome"),
					rs.getString("descricao"),
					rs.getString("data"),
					rs.getString("hora")
				);
				infos.add(info);
			}
			st.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return infos;
	}
	
	
	public List<Informacoes> getByData(String data) {
		List<Informacoes> infos = new ArrayList<>();
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM agendamentos WHERE data = '" + data + "' ORDER BY hora";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Informacoes info = new Informacoes(
					rs.getString("nome"),
					rs.getString("descricao"),
					rs.getString("data"),
					rs.getString("hora")
				);
				infos.add(info);
			}
			st.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return infos;
	}
	
	
	public boolean delete(String data, String nome) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM agendamentos WHERE data = '" + data + "' AND nome = '" + nome + "'";
			System.out.println(sql);
			int linhasAfetadas = st.executeUpdate(sql);
			st.close();
			status = (linhasAfetadas > 0);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
}
