package JavaOOP;

public class Topic_10_OOP_Exercises {
    private int studentID;
    private String studentName;
    private float theoreticalPoint;
    private float practicePoint;

    public Topic_10_OOP_Exercises(int studentID, String studentName, float theoreticalPoint, float practicePoint) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.theoreticalPoint = theoreticalPoint;
        this.practicePoint = practicePoint;
    }
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getTheoreticalPoint() {
        return theoreticalPoint;
    }

    public void setTheoreticalPoint(float theoreticalPoint) {
        this.theoreticalPoint = theoreticalPoint;
    }

    public float getPracticePoint() {
        return practicePoint;
    }

    public void setPracticePoint(float practicePoint) {
        this.practicePoint = practicePoint;
    }
    public float calculateMeanPoint(){
        float meanPoint = (theoreticalPoint + (practicePoint*2))/3;
        return meanPoint;
    }

    //ham tinh diem trung binh
    public static void main(String[] args){
        Topic_10_OOP_Exercises student01 = new Topic_10_OOP_Exercises(10, "name_1",7.5f,6.5f);
        Topic_10_OOP_Exercises student02 = new Topic_10_OOP_Exercises(11, "name_2",6.5f,7.5f);
        Topic_10_OOP_Exercises student03 = new Topic_10_OOP_Exercises(12, "name_1",8.5f,9.5f);
        float std01MeanPoint = student01.calculateMeanPoint();
        float std02MeanPoint = student02.calculateMeanPoint();
        float std03MeanPoint = student03.calculateMeanPoint();
        System.out.println("Student ID: " + student01.studentID + ", Name: " + student01.studentName + ", Mean Point: " + std01MeanPoint);
        System.out.println("Student ID: " + student02.studentID + ", Name: " + student02.studentName + ", Mean Point: " + std02MeanPoint);
        System.out.println("Student ID: " + student03.studentID + ", Name: " + student03.studentName + ", Mean Point: " + std03MeanPoint);
    }

}
