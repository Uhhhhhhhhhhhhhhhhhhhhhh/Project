DROP TABLE IF EXISTS FinalCourseAssignment;
DROP TABLE IF EXISTS ProfessorTimePref;
DROP TABLE IF EXISTS TimePeriod;
DROP TABLE IF EXISTS Section;
DROP TABLE IF EXISTS Prereqs;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Faculty;

CREATE TABLE Faculty (
	PSU_ID VARCHAR(30) NOT NULL PRIMARY KEY,
    Last_Name VARCHAR(30) NOT NULL,
    First_Name VARCHAR(30) NOT NULL,
    Major_College VARCHAR(45),
    Preferred_Days int
);

CREATE TABLE Room (
	Room_ID VARCHAR(5) NOT NULL,
    Building VARCHAR(35) NOT NULL,
    Occupancy SMALLINT NOT NULL,
    Num_of_Computers TINYINT,
    Lab_Type VARCHAR(15),
    PRIMARY KEY(Building, Room_ID)
);

CREATE TABLE Course (
	Course_ID VARCHAR(6) NOT NULL PRIMARY KEY,
    Sub VARCHAR(20) NOT NULL,
    Course_Num VARCHAR(30) NOT NULL,
    course_name VARCHAR(1000) NOT NULL,
    Description TEXT NOT NULL,
    Units DOUBLE NOT NULL
);

CREATE TABLE Prereqs (
	Course_ID VARCHAR(6) NOT NULL,
    Prereq_Course_ID VARCHAR(6) NOT NULL,
    PRIMARY KEY(Course_ID, Prereq_Course_ID),
    FOREIGN KEY (Course_ID) REFERENCES Course(Course_ID),
    FOREIGN KEY (Prereq_Course_ID) REFERENCES Course(Course_ID)
);

CREATE TABLE TimePeriod (
	Period INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Start_Time TIME NOT NULL,
    End_Time TIME NOT NULL
);

CREATE TABLE ProfessorTimePref (
	TimePeriod_Period INT NOT NULL,
    Faculty_PSU_ID VARCHAR(7) NOT NULL,
    PRIMARY KEY(TimePeriod_Period, Faculty_PSU_ID),
    FOREIGN KEY (TimePeriod_Period) REFERENCES TimePeriod(Period),
    FOREIGN KEY (Faculty_PSU_ID) REFERENCES Faculty(PSU_ID)
);

CREATE TABLE FinalCourseAssignment (
	Room_Room_ID VARCHAR(5) NOT NULL REFERENCES Room(Room_ID),
    Room_Building VARCHAR(15) NOT NULL REFERENCES Room(Building),
    Section_Num VARCHAR(7) NOT NULL,
    Course_Course_ID VARCHAR(6) NOT NULL REFERENCES Course(Course_Course_ID),
    Faculty_PSU_ID VARCHAR(7) NOT NULL REFERENCES Faculty(PSU_ID),
    Time_Period INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    Days int NOT NULL,
    Class_Capacity int NOT NULL,
    Enrollment int NOT NULL,
    Course_Type VARCHAR(3) NOT NULL,
    PRIMARY KEY(Course_Course_ID, Section_Num)
);