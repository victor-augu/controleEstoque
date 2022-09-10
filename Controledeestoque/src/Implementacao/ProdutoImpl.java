/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacao;

import Classes.Produto;
import Classes.Usuario;
import ConexaoDB.ConexaoDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class ProdutoImpl {
    
     public void inserirProduto(Produto produto) {
        ConexaoDB conexao = new ConexaoDB();
        conexao.conectar();

        boolean codExiste = false;
        ResultSet rst = null;

        //JOptionPane.showMessageDialog(null, " usuario.getNomeLogin() " + usuario.getNomeLogin());
        try {
            String sql = "SELECT COUNT(*) existe FROM produtos WHERE codProduto = ?";
            PreparedStatement pst = (PreparedStatement) conexao.conexao.prepareStatement(sql);
            pst.setInt(1, produto.getCodProduto());

            rst = pst.executeQuery();

            while (rst.next()) {
                Integer aux = rst.getInt("existe");
                if (aux.equals(0)) {
                    codExiste = false;
                } else {
                    codExiste = true;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar se o produto existe no banco de dados INSERIR. " + ex.getMessage());
            return;
        }
        
        
        if (codExiste) {
            try {
                String sql = " UPDATE produtos " // produto
                        + "    SET    descricao = ?, " // descricao
                        + "           valor = ? " //valor
                        + " WHERE codproduto = ?";  // codproduto = ?

                PreparedStatement pst = (PreparedStatement) conexao.conexao.prepareStatement(sql);
                pst.setString(1, produto.getDescricao());
                pst.setFloat(2, produto.getValor());
                pst.setInt(3, produto.getCodProduto());

                pst.execute();

                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar os dados do produto no banco de dados." + ex.getMessage());
            }
        } else {
            try {
                String sql = "INSERT INTO produtos (descricao, valor) VALUES (?,?)"; ///produtos
                PreparedStatement pst = (PreparedStatement) conexao.conexao.prepareStatement(sql);

             
                pst.setString(1, produto.getDescricao());
                pst.setFloat(2, produto.getValor());
                pst.execute();

                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados  do usuario no banco de dados." + ex.getMessage());
            }
        }
        conexao.desconectar();
    }
    
     public void popularTabela(JTable jTable1) {
        ConexaoDB conexao = new ConexaoDB();
        conexao.conectar();

        while (jTable1.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(0);
        }

        ResultSet rst = null;

        try {
            String sql = "SELECT * FROM produtos ORDER BY descricao";
            PreparedStatement pst = (PreparedStatement) conexao.conexao.prepareStatement(sql);

            rst = pst.executeQuery();
            while (rst.next()) {
                DefaultTableModel tabelaAlunos = (DefaultTableModel) jTable1.getModel(); //pega modelo da tabela

                String codproduto = rst.getString("codproduto");
                String descicao = rst.getString("descricao");
                String valor = rst.getString("valor");
                
                Object[] obj = {codproduto, descicao, valor};

                tabelaAlunos.addRow(obj);
            };
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular tabela!\nErro: " + ex.getMessage());
        }

        conexao.desconectar();
    }
     
    public void pesquisarTabela(JTable jTable1, Produto produto) {
        ConexaoDB conexao = new ConexaoDB();
        conexao.conectar();

        while (jTable1.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(0);
        }

        ResultSet rst = null;

        try {
            String sql = "SELECT * FROM produtos WHERE UPPER(descricao) like UPPER(?) ORDER BY descricao";
            PreparedStatement pst = (PreparedStatement) conexao.conexao.prepareStatement(sql);
            pst.setString(1, '%' + produto.getDescricao()+ '%');

            rst = pst.executeQuery();
            while (rst.next()) {
                DefaultTableModel tabelaproduto = (DefaultTableModel) jTable1.getModel(); //pega modelo da tabela

                String codproduto = rst.getString("codproduto");
                String descicao = rst.getString("descricao");
                String valor = rst.getString("valor");
                

                Object[] obj = {codproduto, descicao, valor};

                tabelaproduto.addRow(obj);
            };
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular tabela!\nErro: " + ex.getMessage());
        }

        conexao.desconectar();
    }
     
   
     
     
     public void excluirProduto(Produto produto) { 
        ConexaoDB conexao = new ConexaoDB();
        conexao.conectar();

        try {
            String sql = "DELETE FROM produtos WHERE codproduto = ? ";
            PreparedStatement pst = (PreparedStatement) conexao.conexao.prepareStatement(sql);
            pst.setInt(1, produto.getCodProduto());

            pst.execute();
            
            JOptionPane.showMessageDialog(null, "DELETADO com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao DELETAR usuário!\nErro: " + ex.getMessage());
        }

        conexao.desconectar();
    }
}
