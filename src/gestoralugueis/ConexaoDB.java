package gestoralugueis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/gestor_alugueis_db";
    private static final String USER = "root";
    private static final String PASS = "8403"; 

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Erro de conexão com o banco de dados: " + e.getMessage(), 
                "Erro Crítico", javax.swing.JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
