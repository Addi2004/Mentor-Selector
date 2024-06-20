# Mentor Selector

This project is a Mentor Selector application that helps users choose the best mentor based on their area of interest and specialization. It consists of a Java-based backend connected to a MySQL database and a front-end developed using HTML, CSS, and JavaScript.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)

## Features
- Allows users to select a specialization and area of study.
- Fetches mentor details from a MySQL database based on the user's choices.
- Displays the best mentor based on experience.
- Interactive and user-friendly web interface.

## Requirements
- Java Development Kit (JDK) 8 or later
- MySQL Server
- Web browser (for the front-end)

## Installation

### Backend
1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/mentor-selector.git
    cd mentor-selector
    ```

2. **Set up MySQL Database:**
    - Create a new MySQL database named `mentorselector`.
    - Create a table `mentors` with the following schema:
        ```sql
        CREATE TABLE mentors (
            id INT AUTO_INCREMENT PRIMARY KEY,
            mentorname VARCHAR(100),
            experience INT,
            contactno VARCHAR(15),
            emailid VARCHAR(100),
            specialization VARCHAR(50),
            area_of_study VARCHAR(50)
        );
        ```
    - Populate the `mentors` table with some sample data.

3. **Configure the database connection:**
    - Update the database connection details in `MentorSelector.java`:
        ```java
        String url = "jdbc:mysql://localhost:3306/mentorselector";
        String user = "root";
        String password = "yourpassword";
        ```

4. **Compile and run the Java program:**
    ```bash
    javac MentorSelector.java
    java MentorSelector
    ```

### Frontend
1. **Open `index.html` in your web browser:**
    - Navigate to the `frontend` directory.
    - Open `index.html` in a web browser to interact with the application.

## Usage
1. **Backend:**
    - Run the `MentorSelector` Java application.
    - Follow the console prompts to select a specialization and area of study.
    - The application will display the best mentor based on the selected criteria.

2. **Frontend:**
    - Open the `index.html` file in your web browser.
    - Choose your specialization and area of study from the dropdown menus.
    - Click the "Apply" button to view the mentor details.

## Database Schema
- **mentors**
    - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
    - `mentorname` (VARCHAR(100))
    - `experience` (INT)
    - `contactno` (VARCHAR(15))
    - `emailid` (VARCHAR(100))
    - `specialization` (VARCHAR(50))
    - `area_of_study` (VARCHAR(50))

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

1. **Fork the repository**
2. **Create a new branch**
    ```bash
    git checkout -b feature-branch
    ```
3. **Make your changes**
4. **Commit your changes**
    ```bash
    git commit -m "Description of changes"
    ```
5. **Push to your branch**
    ```bash
    git push origin feature-branch
    ```
6. **Open a pull request**

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

Feel free to open an issue if you have any questions or need further assistance. Happy coding!