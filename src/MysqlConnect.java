import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnect {

    private static final String url="jdbc:mysql://localhost:3306/victorina";
    private static final String login="victorina";
    private static final String password="victorina";


    public Connection connect(){
        Connection connection=null;
        try{
            Properties properties=new Properties();
            properties.put("user",login);
            properties.put("password",password);
            properties.put("useUnicode","true");
            properties.put("characterEncoding","cp1251");
            connection= DriverManager.getConnection(url,properties);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public boolean Close(Connection connection){
        boolean returnValue=false;
        try{
            connection.close();
            returnValue=true;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return returnValue;
    }
}
