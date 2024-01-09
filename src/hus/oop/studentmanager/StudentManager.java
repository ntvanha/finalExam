package hus.oop.studentmanager;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    private static StudentManager instance;  // Singleton pattern
    private Map<String, Student> students;  // Lưu danh sách sinh viên đọc được từ file dữ liệu.

    private StudentManager() {
        students = new HashMap<>();
    }

    /**
     * Singleton pattern.
     * @return đối tượng duy nhất có thể được tạo ra.
     */
    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    /**
     * Lấy ra danh sách sinh viên.
     * @return
     */
    public List<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    /**
     * Thêm sinh viên vào.
     * @param student
     */
    public void put(Student student) {
        students.put(student.getId(), student);
    }

    /**
     * Xóa sinh viên theo id.
     * @param id
     */
    public void remove(String id) {
        students.remove(id);
    }

    /**
     * Tìm và lấy ra sinh viên theo id.
     * @param id
     * @return
     */
    public Student studentById(String id) {
        return students.get(id);
    }

    // Other methods for sorting and filtering...

    /**
     * In ra danh sách sinh viên theo định dạng.
     * @param studentList
     */
    public static void print(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i) + " ");
        }
    }
}
