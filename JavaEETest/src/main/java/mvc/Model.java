package mvc;

public class Model {

    public StudentBean getStudent(){
        StudentBean student = new StudentBean();
        student.setName("Karl");
        student.setAge(67);

        return student;
    }
}
