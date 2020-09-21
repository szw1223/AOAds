public class Student {
    public String name;
    public int age;
    public static boolean isRich;

    public Student(String s) {
        this.name = s;
        Student.isRich = false;
    }

    public boolean getrich() {
        return isRich;
    }

    public static void ipo() {
        Student.isRich = true;
    }

    public void setAge(int ag) {
        age = ag;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Student stuExam = new Student("jasper");
        System.out.println(stuExam.getAge());
        stuExam.setAge(13);
        System.out.println(stuExam.getAge());
        Student stuThird = null;
        try {
            System.out.println(stuThird.getAge());
        } catch (NullPointerException f) {
            System.out.println("-1asdf" + f.toString());
        }
        System.out.println(stuExam.getrich());
        Student.ipo();
        System.out.println(stuExam.getrich());

    }
}
