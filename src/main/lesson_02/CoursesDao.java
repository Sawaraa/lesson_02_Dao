import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesDao {
    static String READ_ALL = "select * from allCourses";
    static String CREATE = "insert into allcourses(name, countLessons) value (?,?)";
    static String DELETE = "delete from allcourses where id=?";
    static String UPDATE = "update allcourses set name=?, countLessons=? where id=? ";


   private Connection connection;
   private PreparedStatement preparedStatement;

    public CoursesDao(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public void create(Courses courses) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, courses.getName());
        preparedStatement.setInt(2,courses.getCountLessons());
        preparedStatement.executeUpdate();
    }

    public List<Courses> read() throws SQLException {
        List<Courses> coursesList = new ArrayList<>();
        preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            coursesList.add(CourseMapper.map(resultSet));
        }

        return coursesList;
    }

    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public void update(Courses courses) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, courses.getName());
        preparedStatement.setInt(2,courses.getCountLessons());
        preparedStatement.setInt(3,courses.getId());
        preparedStatement.executeUpdate();
    }


}
