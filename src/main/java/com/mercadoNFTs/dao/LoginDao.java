package com.mercadoNFTs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mercadoNFTs.conexao.Conexao;
import com.mercadoNFTs.control.Login;

public class LoginDao {
		
	Connection con;//conectar ao banco de dados
    PreparedStatement ps;//executar comandos sql
    ResultSet rs;//armazena o resultado do select
    String sql;	
	public Login pesquisar(Login login) {
        Login loginBuscado = new Login();

        try {
        	con = Conexao.conectar();
            String query = "SELECT id_usuarios, email, senha FROM tb_usuarios WHERE email = ? AND senha = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getSenha());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                loginBuscado.setId(rs.getInt("id_usuarios"));
                loginBuscado.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }

        return loginBuscado;
    }
}
