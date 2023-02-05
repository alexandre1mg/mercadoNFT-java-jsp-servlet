package com.mercadoNFTs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mercadoNFTs.conexao.Conexao;
import com.mercadoNFTs.model.Item;
import com.mercadoNFTs.model.Usuario;


public class ItemDao {
		
	Connection con;//conectar ao banco de dados
    PreparedStatement ps;//executar comandos sql
    ResultSet rs;//armazena o resultado do select
    String sql;
	
    public ArrayList<Item> pesquisar(int id_user) {
        ArrayList<Item> listaItem = new ArrayList<Item>();
        try {
        	con = Conexao.conectar();
            String query = "SELECT id_item,nome,descricao,imagem  FROM tb_itens where id_usuarios=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            Item item;
            while (rs.next()) {
            	item = new Item();
            	item.setNome(rs.getString("nome"));
            	item.setDescricao(rs.getString("descricao"));
            	item.setId(rs.getInt("id_item"));
            	item.setImagem(rs.getString("imagem"));
            	
                listaItem.add(item);
            }
    
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return listaItem;
    }
    
    public ArrayList<Item> pesquisarItem(int id_item) {
        ArrayList<Item> listaItem = new ArrayList<Item>();
        try {
        	con = Conexao.conectar();
            String query = "SELECT id_item,nome,descricao  FROM tb_itens where id_item=?";
            ps = con.prepareStatement(query);
            ps.setInt(2, id_item);
            ResultSet rs = ps.executeQuery();
            Item item;
            while (rs.next()) {
            	item = new Item();
            	item.setNome(rs.getString("nome"));
            	item.setDescricao(rs.getString("descricao"));
            	item.setId(rs.getInt("id_item"));
            	
                listaItem.add(item);
            }
    
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return listaItem;
    }
    
    public ArrayList<Item> pesquisarTudo() {
        ArrayList<Item> listaItem = new ArrayList<Item>();
        try {
        	con = Conexao.conectar();
            String query = "SELECT nome,descricao,imagem  FROM tb_itens ORDER BY (id_item) DESC";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Item item;
            while (rs.next()) {
                item = new Item();
                item.setNome(rs.getString("nome"));
                item.setDescricao(rs.getString("descricao"));
                item.setImagem(rs.getString("imagem"));
                
                listaItem.add(item);
            }
            
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return listaItem;
    }
    
    public ArrayList<Item> procurar(String nm) {
        ArrayList<Item> listaItem = new ArrayList<Item>();
        try {
        	con = Conexao.conectar();
            String query = "SELECT nome,descricao,imagem  FROM tb_itens where nome like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+nm+"%");
            ResultSet rs = ps.executeQuery();
            Item item;
            while (rs.next()) {
                item = new Item();
                item.setNome(rs.getString("nome"));
                item.setDescricao(rs.getString("descricao"));
                item.setImagem(rs.getString("imagem"));
                
                listaItem.add(item);
            }
            
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return listaItem;
    }
	
	public boolean cadastrarItem(Item item,int id) {
        sql = "insert into tb_itens "
        + "(imagem,nome,descricao,id_usuarios) "
        + " values (?,?,?,?)";
        con = Conexao.conectar();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getImagem());
            ps.setString(2, item.getNome());
            ps.setString(3, item.getDescricao());
            ps.setInt(4, id);
            ps.execute();
            con.close();
            System.out.println("Item adicionado com sucesso");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

	public void deletar(Item item) {
		try {
			con = Conexao.conectar();
            String query = "DELETE FROM tb_itens WHERE id_item = ?";
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, item.getId());
            ps.execute();
            
            
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
		
	}
}
