package pl.product.dao;

import pl.product.models.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private final String url = "jdbc:mysql://localhost:3306/plone";
    private final String user = "root";
    private final String password = "root"; // Substitua pela sua senha do MySQL

    public void adicionarCarro(Carro carro) throws SQLException {
        String sql = "INSERT INTO carros (marca, modelo, velocidade_maxima, descricao) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, carro.getMarca());
            statement.setString(2, carro.getModelo());
            statement.setInt(3, carro.getVelocidadeMaxima());
            statement.setString(4, carro.getDescricao());
            statement.executeUpdate();
        }
    }

    public List<Carro> listarCarros() throws SQLException {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carros";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Carro carro = new Carro(
                        resultSet.getInt("id"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("velocidade_maxima"),
                        resultSet.getString("descricao")
                );
                carros.add(carro);
            }
        }
        return carros;
    }

    public void removerCarro(int id) throws SQLException {
        String sql = "DELETE FROM carros WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
