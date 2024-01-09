package hus.oop.studentmanager;

public class Student {
    private final String id;
    private final String lastname;
    private final String firstname;
    private final int yearOfBirth;
    private final double mathsGrade;
    private final double physicsGrade;
    private final double chemistryGrade;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.lastname = builder.lastname;
        this.firstname = builder.firstname;
        this.yearOfBirth = builder.yearOfBirth;
        this.mathsGrade = builder.mathsGrade;
        this.physicsGrade = builder.physicsGrade;
        this.chemistryGrade = builder.chemistryGrade;
    }

    public static StudentBuilder getBuilder(String id) {
        return new StudentBuilder(id);
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getMathsGrade() {
        return mathsGrade;
    }

    public double getPhysicsGrade() {
        return physicsGrade;
    }

    public double getChemistryGrade() {
        return chemistryGrade;
    }

    public double getAverageGrade() {
        return (mathsGrade + physicsGrade + chemistryGrade) / 3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", mathsGrade=" + mathsGrade +
                ", physicsGrade=" + physicsGrade +
                ", chemistryGrade=" + chemistryGrade +
                '}';
    }

    public static final class StudentBuilder {
        private final String id;
        private String lastname;
        private String firstname;
        private int yearOfBirth;
        private double mathsGrade;
        private double physicsGrade;
        private double chemistryGrade;

        public StudentBuilder(String id) {
            this.id = id;
        }

        public StudentBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public StudentBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public StudentBuilder withYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public StudentBuilder withMathsGrade(double mathsGrade) {
            this.mathsGrade = mathsGrade;
            return this;
        }

        public StudentBuilder withPhysicsGrade(double physicsGrade) {
            this.physicsGrade = physicsGrade;
            return this;
        }

        public StudentBuilder withChemistryGrade(double chemistryGrade) {
            this.chemistryGrade = chemistryGrade;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
