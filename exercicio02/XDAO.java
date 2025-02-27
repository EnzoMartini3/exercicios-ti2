import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/meu_banco";
    private static final String USER = "postgres";
    private static final String PASSWORD = "sua_senha";

    public void inserir(X x) {
        String sql = "INSERT INTO X (nome, idade) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, x.getNome());
            stmt.setInt(2, x.getIdade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<X> listar() {
        List<X> lista = new ArrayList<>();
        String sql = "SELECT * FROM X";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new X(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM X WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(X x) {
        String sql = "UPDATE X SET nome = ?, idade = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, x.getNome());
            stmt.setInt(2, x.getIdade());
            stmt.setInt(3, x.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
