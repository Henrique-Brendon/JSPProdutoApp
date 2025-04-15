package com.henrique.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.henrique.model.Categoria;
import com.henrique.model.Produto;

public class ProdutoDAO {
    public List<Produto> listarPorCategoria(int categoriaId) throws Exception {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nome AS nome_categoria FROM produto p JOIN categoria c ON p.categoria_id = c.id WHERE c.id = ?";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, categoriaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                Categoria c = new Categoria();
                c.setId(rs.getInt("categoria_id"));
                c.setNome(rs.getString("nome_categoria"));

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setCategoria(c);

                lista.add(p);
            }
        }
        return lista;
    }
}