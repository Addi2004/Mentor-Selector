import java.sql.*;
import java.util.*;

public class MentorSelector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            String url = "jdbc:mysql://localhost:3306/mentorselector";
            String user = "root";
            String password = "rishab2004";
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Choose a specialization:");
            System.out.println("1. Artificial Intelligence");
            System.out.println("2. Big Data");
            System.out.println("3. CCVT");
            System.out.println("4. IOT");
            System.out.println("5. Cyber Security");

            int specializationChoice = scanner.nextInt();
            String[] specializations = {
                "Artificial Intelligence",
                "Big Data",
                "CCVT",
                "IOT",
                "Cyber Security"
            };

            Map<Integer, String[]> areaOfStudyMap = new HashMap<>();
            areaOfStudyMap.put(1, new String[]{"Geoinformatics", "Machine Learning", "AI in Healthcare"});
            areaOfStudyMap.put(2, new String[]{"Data Science", "Data Analytics", "Data Processing", "Hadoop"});
            areaOfStudyMap.put(3, new String[]{"Cloud Computing", "AWS", "Azure"});
            areaOfStudyMap.put(4, new String[]{"Robotics", "Arduino", "Circuit Boards", "Smart Cities"});
            areaOfStudyMap.put(5, new String[]{"Ethical Hacking", "Network Security", "Ransomware"});

            String[] areaOfStudy = areaOfStudyMap.get(specializationChoice);

            System.out.println("Choose an area of study:");
            for (int i = 0; i < areaOfStudy.length; i++) {
                System.out.println((i + 1) + ". " + areaOfStudy[i]);
            }

            int areaOfStudyChoice = scanner.nextInt();

            String query = "SELECT mentorname, experience, contactno, emailid FROM mentors WHERE specialization = ? AND area_of_study = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, specializations[specializationChoice - 1]);
            preparedStatement.setString(2, areaOfStudy[areaOfStudyChoice - 1]);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Mentor> mentors = new ArrayList<>();

            while (resultSet.next()) {
                String mentorName = resultSet.getString("mentorname");
                int experience = resultSet.getInt("experience");
                String contactNo = resultSet.getString("contactno");
                String emailId = resultSet.getString("emailid");
                mentors.add(new Mentor(mentorName, experience, contactNo, emailId));
            }

            mentors.sort((mentor1, mentor2) -> Integer.compare(mentor2.getExperience(), mentor1.getExperience()));

            if (!mentors.isEmpty()) {
                Mentor bestMentor = mentors.get(0);
                System.out.println("Best Mentor: " + bestMentor.getName() + " (Experience: " + bestMentor.getExperience() + " years)");
                System.out.println("Contact No: " + bestMentor.getContactNo());
                System.out.println("Email ID: " + bestMentor.getEmailId());
            } else {
                System.out.println("No mentors available for the selected area of study.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

class Mentor {
    private String name;
    private int experience;
    private String contactNo;
    private String emailId;

    public Mentor(String name, int experience, String contactNo, String emailId) {
        this.name = name;
        this.experience = experience;
        this.contactNo = contactNo;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmailId() {
        return emailId;
    }
}
