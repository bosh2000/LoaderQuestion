import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDao {

    MysqlConnect mysqlConnect;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String SQL = "INSERT INTO question (id,question,answer) VALUES (?,?,?)";


    MysqlDao() {
        mysqlConnect = new MysqlConnect();
        connection = mysqlConnect.connect();
    }

    public boolean AddQuestionToBase(Question question, int index) {
        boolean returnValue = false;
        try {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,index);
            preparedStatement.setString(2, question.question);
            preparedStatement.setString(3, question.answer);
            preparedStatement.executeUpdate();
            returnValue = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }


    public void Close() {
        try {
            mysqlConnect.Close(connection);
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
