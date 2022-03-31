package com.mycompany;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Template {

    MySQLR mysqlr;

    public Template() {
        mysqlr = new MySQLR();
    }

    public static void main(String[] args) {
        try {
            Template template = new Template();
            template.conectar();
            template.inserir();
            //template.consultar();
            //template.alterar();
            //template.excluir();
            template.mysqlr.stmt.close();
            template.mysqlr.conn.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void conectar() {
        boolean connected = mysqlr.connect("localhost", "3306", "banco", "root", "laboratorio");
        if (connected) {
            System.out.println("Base de dados conectada.");
        } else {
            System.out.println("Base de dados não conectada.");
        }
    }

    public void inserir() {
        Carro c = new Carro();
        c.setNome(JOptionPane.showInputDialog(null, "Digite o nome do carro: "));
        c.setMarca(JOptionPane.showInputDialog(null, "Digite marca do carro: "));
        c.setCor(JOptionPane.showInputDialog(null, "Digite a cor do carro: "));
        c.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano do carro: ")));
        
        String query = "INSERT INTO Carro (nome, marca, cor, ano) "
                + "values ('" + c.getNome() + "', '" + c.getMarca() + "', '" + c.getCor() + "', '" + c.getAno() + "')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }

    public void consultar() {
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM Carro");
        if (rs != null) {
            try {
                while (rs.next()) {
                    // É possível referenciar a coluna pelo índice 
                    System.out.println("Id: " + rs.getString(1));
                    // Ou pelo nome
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Marca: " + rs.getString("marca"));
                    System.out.println("Cor: " + rs.getString("cor"));
                    System.out.println("Ano: " + rs.getString("ano"));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    /* 
    public void alterar(){
        int status;
        String nome = "Paulo";
        String email = "paulo@ufn.edu.br";
        String cidade = "Vacaria";
        String query = "UPDATE Pessoa SET nome='" + nome + "', "
                    + "email='" + email + "', cidade='" + cidade + "'  "
                    + "WHERE id=" + 2;
        status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }
    
    public void excluir(){
        String query = "DELETE FROM Pessoa WHERE id=" + 2;
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
        } else {
            System.out.println("Erro ao excluir dados!");
        }  
    } 
     */
}
