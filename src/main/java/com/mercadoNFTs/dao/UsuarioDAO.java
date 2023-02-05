package com.mercadoNFTs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mercadoNFTs.conexao.Conexao;
import com.mercadoNFTs.model.Usuario;



public class UsuarioDAO {

	Connection con;//conectar ao banco de dados
    PreparedStatement ps;//executar comandos sql
    ResultSet rs;//armazena o resultado do select
    String sql;

    public boolean cadastrar(Usuario usuario) {
        sql = "insert into tb_usuarios "
        + "(nome,CPF,email, senha) "
        + " values (?,?,?,?)";
        con = Conexao.conectar();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.execute();
            con.close();
            System.out.println("Cadastrado com sucesso");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public ArrayList<Usuario> pesquisar(int id) {
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {
        	con = Conexao.conectar();
            String query = "SELECT nome,CPF,email  FROM tb_usuarios where id_usuarios=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Usuario usuario;
            while (rs.next()) {
            	usuario = new Usuario();
            	usuario.setNome(rs.getString("nome"));
            	usuario.setCpf(rs.getString("CPF"));
            	usuario.setEmail(rs.getString("email"));
            	
                listaUsuario.add(usuario);
            }
    
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return listaUsuario;
    }

	public void alterar(Usuario usuario) {
		 try {
			 	con = Conexao.conectar();
	            String query = "UPDATE tb_usuarios SET nome = ?, CPF = ?, email=? WHERE id_usuarios = ?";
	            ps = con.prepareStatement(query);
	            ps.setString(1, usuario.getNome());
	            ps.setString(2, usuario.getCpf());
	            ps.setString(3, usuario.getEmail());
	            ps.setInt(4, usuario.getId());
	            ps.executeUpdate();
	            

	        } catch (Exception e) {
	            System.out.println("Erro " + e.getMessage());
	        }
		
	}

}
