package hus.oop.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static StudentManager studentManager = StudentManager.getInstance();

    public static void main(String[] args) {
        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
            + Sinh viên được viết thêm code để thực hiện chương trình.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
        init();
        System.out.println("Test Original Data");
        testOriginalData();
        System.out.println();

        System.out.println("Test find student by id");
        testFindStudentById();
        System.out.println();

        System.out.println("Test Sort Year Of Birth Increasing");
        testSortYearOfBirthIncreasing();
        System.out.println();

        System.out.println("Test Sort Year Of Birth Decreasing");
        testSortYearOfBirthDecreasing();
        System.out.println();

        System.out.println("Test Sort Maths Grade Increasing");
        testSortMathsGradeIncreasing();
        System.out.println();

        System.out.println("Test Sort Maths Grade Decreasing");
        testSortMathsGradeDecreasing();
        System.out.println();

        System.out.println("Test Sort Physics Grade Increasing");
        testSortPhysicsGradeIncreasing();
        System.out.println();

        System.out.println("Test Sort Physics Grade Decreasing");
        testSortPhysicsGradeDecreasing();
        System.out.println();

        System.out.println("Test Sort Chemistry Grade Increasing");
        testSortChemistryGradeIncreasing();
        System.out.println();

        System.out.println("Test Sort Chemistry Grade Decreasing");
        testSortChemistryGradeDecreasing();
        System.out.println();

        System.out.println("Test Sort Average Grade Increasing");
        testSortAverageGradeIncreasing();
        System.out.println();

        System.out.println("Test Sort Average Grade Decreasing");
        testSortAverageGradeDecreasing();
        System.out.println();

        System.out.println("Test Filter Students Highest Maths Grade");
        testFilterStudentsHighestMathsGrade();
        System.out.println();

        System.out.println("Test Filter Students Lowest Maths Grade");
        testFilterStudentsLowestMathsGrade();
        System.out.println();

        System.out.println("Test Filter Students Highest Physics Grade");
        testFilterStudentsHighestPhysicsGrade();
        System.out.println();

        System.out.println("Test Filter Students Lowest Physics Grade");
        testFilterStudentsLowestPhysicsGrade();
        System.out.println();

        System.out.println("Test Filter Students Highest Chemistry Grade");
        testFilterStudentsHighestChemistryGrade();
        System.out.println();

        System.out.println("Test Filter Students Lowest Chemistry Grade");
        testFilterStudentsLowestChemistryGrade();
        System.out.println();

        System.out.println("Test Filter Students Highest Average Grade");
        testFilterStudentsHighestAverageGrade();
        System.out.println();

        System.out.println("Test Filter Students Lowest Average Grade");
        testFilterStudentsLowestAverageGrade();
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                Đọc dự liệu từ file và tạo ra các đối tượng sinh viên,
                sau đó cho vào đối tượng được thiết kế kiểu singleton StudentManager để quản lý 
                thông tin sinh viên.
                */
                Student newStudent = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();

                studentManager.put(newStudent);
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void init() {
        String filePath = "D:\\CTDL_chieuThu3\\cuoiKi\\src\\data\\students.csv";
        readListData(filePath);
    }

    /**
     * Test in ra dữ liệu gốc danh sách sinh viên.
     */
    public static void testOriginalData() {
        /* TODO */
        List<Student> students = studentManager.getStudents();
        StudentManager.print(students);
        System.out.println();
    }

    /**
     * Test in ra thông tin về một sinh viên được tìm theo id theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     */
    public static void testFindStudentById() {
        /* TODO */
        String id = "22001878";
        Student student = StudentManager.getInstance().studentById(id);
        System.out.println("Student by id " + id + " is: " + "\n" + student);
    }

    /**
     * Test in ra danh sách sinh viên có năm sinh tăng dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortYearOfBirthIncreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingInt(Student::getYearOfBirth));
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có năm sinh giảm dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortYearOfBirthDecreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingInt(Student::getYearOfBirth).reversed());
        StudentManager.print(sortedStudents);
        System.out.println();
    }


    /**
     * Test in ra danh sách sinh viên có điểm Toán tăng dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortMathsGradeIncreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getMathsGrade));
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có điểm Toán giảm dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortMathsGradeDecreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getMathsGrade).reversed());
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có điểm Lý tăng dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortPhysicsGradeIncreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getPhysicsGrade));
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có điểm Lý giảm dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortPhysicsGradeDecreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getPhysicsGrade).reversed());
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có điểm Hóa tăng dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortChemistryGradeIncreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getChemistryGrade));
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có điểm Hóa tăng dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortChemistryGradeDecreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getChemistryGrade).reversed());
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có điểm trung bình tăng dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortAverageGradeIncreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getAverageGrade));
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test in ra danh sách sinh viên có điểm trung bình giảm dần theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testSortAverageGradeDecreasing() {
        List<Student> sortedStudents = studentManager.getStudents();
        Collections.sort(sortedStudents, Comparator.comparingDouble(Student::getAverageGrade).reversed());
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /**
     * Test lọc và in ra danh sách n sinh viên có điểm Toán cao nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsHighestMathsGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getMathsGrade).reversed())
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }

    /**
     * Test lọc và in ra danh sách n sinh viên có điểm Toán thấp nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsLowestMathsGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getMathsGrade))
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }

    /**
     * Test lọc và in ra danh sách n sinh viên có điểm Lý cao nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsHighestPhysicsGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getPhysicsGrade).reversed())
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }
    /**
     * Test lọc và in ra danh sách n sinh viên có điểm Lý thấp nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsLowestPhysicsGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getPhysicsGrade))
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }

    /**
     * Test lọc và in ra danh sách n sinh viên có điểm Hóa cao nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsHighestChemistryGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getChemistryGrade).reversed())
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }


    /**
     * Test lọc và in ra danh sách n sinh viên có điểm Hóa thấp nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsLowestChemistryGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getChemistryGrade))
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }
    /**
     * Test lọc và in ra danh sách n sinh viên có điểm trung bình cao nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsHighestAverageGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }
    /**
     * Test lọc và in ra danh sách n sinh viên có điểm trung bình thấp nhất,
     * trong đó n được sinh ngẫu nhiên trong đoạn [5, 10] theo định dạng:
     * Nguyễn Văn A, id = 123456, yob = 2001, Toán = 8, Lý = 8, Hóa 8, trung bình = 8
     * Nguyễn Văn B, id = 123456, yob = 2001, Toán = 9, Lý = 9, Hóa 9, trung bình = 9
     * ...
     */
    public static void testFilterStudentsLowestAverageGrade() {
        int n = new Random().nextInt(6) + 5; // Random number of students to display (between 5 and 10)
        List<Student> filteredStudents = studentManager.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .limit(n)
                .collect(Collectors.toList());
        StudentManager.print(filteredStudents);
        System.out.println();
    }
}
