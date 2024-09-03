import java.sql.*;

public class MySQLConnector {
    public static Connection conectar(){

        String status = "Nada aconteceu ainda...";
        String mysqlHost = "127.0.0.1";
        String mysqlDb = "db_mysql_connector";
        String mysqlUser = "root";
        String mysqlPassword = "senac@02";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        Connection conn = null;
        try{

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com sucesso!";

        }catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){

            status = "Ops! Algo de errado nao esta certo com a conexao com o banco de dados MySQL! Mensagem do servidor" + e;


        }
        System.out.println(status);
        return conn;



    }
}
