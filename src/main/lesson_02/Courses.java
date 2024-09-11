public class Courses {


    private String name;
    private int countLessons;
    private int id;

    public Courses(String name, int countLessons, int id) {
        this.name = name;
        this.countLessons = countLessons;
        this.id = id;
    }

    public Courses(String name, int countLessons) {
        this.name = name;
        this.countLessons = countLessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountLessons() {
        return countLessons;
    }

    public void setCountLessons(int countLessons) {
        this.countLessons = countLessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", countLessons=" + countLessons +
                ", id=" + id +
                '}';
    }
}
