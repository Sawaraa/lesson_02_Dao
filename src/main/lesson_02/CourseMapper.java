import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper {

    public static Courses map(ResultSet resultSet) throws SQLException {
        String name = resultSet.getNString("name");
        int count = resultSet.getInt("countLessons");
        int id = resultSet.getInt("id");
        Courses courses = new Courses(name, count, id);
        return courses;
    }
}
