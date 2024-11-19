package pl.product.dao;

import pl.product.models.Computador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAO {
    private final String url = "jdbc:mysql://localhost:3306/plone";
    private final String user = "root";
    private final String password = "root";

    public List<Computador> listarProgramas() {
        List<Computador> programas = new ArrayList<>();
        String sql = "SELECT id, programa FROM computador";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Computador computador = new Computador(
                        resultSet.getInt("id"),
                        resultSet.getString("programa")
                );
                programas.add(computador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programas;
    }

    public void adicionarPrograma(String programa) {
        String sql = "INSERT INTO computador (programa) VALUES (?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, programa);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerPrograma(int id) {
        String sql = "DELETE FROM computador WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Computador> listarComponentes() {
        List<Computador> componentes = new ArrayList<>();
        String sql = "SELECT id, componentes, uso FROM computador_comp";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Computador componente = new Computador(
                        resultSet.getInt("id"),
                        null, // programa não é usado aqui
                        resultSet.getString("componentes"),
                        resultSet.getInt("uso")
                );
                componentes.add(componente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return componentes;
    }

    public void atualizarUso(String componente, int novoUso) {
        String sql = "UPDATE computador_comp SET uso = ? WHERE componentes = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, novoUso);
            preparedStatement.setString(2, componente);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
