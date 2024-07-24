import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private ArrayList<Student> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents.size();
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        return registeredStudents.remove(student);
    }

    public void displayCourseDetails() {
        System.out.println(courseCode + ": " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Schedule: " + schedule);
        System.out.println("Available Slots: " + getAvailableSlots());
    }
}

class Student {
    private String studentId;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void registerCourse(Course course) {
        if (course.registerStudent(this)) {
            registeredCourses.add(course);
            System.out.println("Registered for course: " + course.getTitle());
        } else {
            System.out.println("Registration failed. Course is full.");
        }
    }

    public void dropCourse(Course course) {
        if (course.removeStudent(this)) {
            registeredCourses.remove(course);
            System.out.println("Dropped course: " + course.getTitle());
        } else {
            System.out.println("Course not found in registered courses.");
        }
    }

    public void displayRegisteredCourses() {
        System.out.println("Registered Courses for " + name + ":");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle());
        }
    }
}

public class task5 {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample data
        courses.add(new Course("CS101", "Introduction to Computer Science", "Basics of computer science", 30, "MWF 9:00-10:00"));
        courses.add(new Course("MATH101", "Calculus I", "Introduction to calculus", 40, "TTh 10:00-11:30"));

        students.add(new Student("S001", "Alice"));
        students.add(new Student("S002", "Bob"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\nCourse Registration System Menu:");
            System.out.println("1. List Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. List Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listCourses();
                    break;
                case 2:
                    registerForCourse(scanner);
                    break;
                case 3:
                    dropCourse(scanner);
                    break;
                case 4:
                    listRegisteredCourses(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void listCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }

    public static void registerForCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code to Register: ");
        String courseCode = scanner.next();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.registerCourse(course);
    }

    public static void dropCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code to Drop: ");
        String courseCode = scanner.next();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.dropCourse(course);
    }

    public static void listRegisteredCourses(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
        Student student = findStudentById(studentId);
        if (student != null) {
            student.displayRegisteredCourses();
        } else {
            System.out.println("Student not found.");
        }
    }

    public static Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}


