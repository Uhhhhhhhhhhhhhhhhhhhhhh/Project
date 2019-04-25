DROP TABLE IF EXISTS FinalCourseAssignment;
DROP TABLE IF EXISTS ProfessorTimePref;
DROP TABLE IF EXISTS TimePeriod;
DROP TABLE IF EXISTS Prereqs;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Faculty;

CREATE TABLE Faculty (
	PSU_ID VARCHAR(30) NOT NULL PRIMARY KEY,
    Last_Name VARCHAR(30) NOT NULL,
    First_Name VARCHAR(30) NOT NULL,
    Major_College VARCHAR(45),
	Employment_Type VARCHAR(50) NOT NULL
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
	Course_ID int not null PRIMARY KEY auto_increment,
    Sub VARCHAR(20) NOT NULL,
    Course_Num VARCHAR(30) NOT NULL,
    course_name VARCHAR(1000) NOT NULL,
    Description TEXT NOT NULL,
    Units DOUBLE NOT NULL
);

CREATE TABLE Prereqs (
	Course_ID int NOT NULL,
    Prereq_Course_ID int NOT NULL,
    PRIMARY KEY(Course_ID, Prereq_Course_ID),
    FOREIGN KEY (Course_ID) REFERENCES Course(Course_ID),
    FOREIGN KEY (Prereq_Course_ID) REFERENCES Course(Course_ID)
);

CREATE TABLE TimePeriod (
	Period INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	Days VARCHAR(7),
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
    Course_Course_ID int NOT NULL REFERENCES Course(Course_Course_ID),
    Faculty_PSU_ID VARCHAR(7) NOT NULL REFERENCES Faculty(PSU_ID),
    Time_Period INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    Class_Capacity int NOT NULL,
    Enrollment int NOT NULL,
    Course_Type VARCHAR(3) NOT NULL,
    PRIMARY KEY(Course_Course_ID, Section_Num)
);

-- Monday, Wednesday, Friday
INSERT into timeperiod(days, start_time, end_time) 
values ('1010100', '08:00:00', '08:50:00'), 
('1010100', '09:05:00', '09:55:00'),
('1010100', '10:10:00', '11:00:00'),
('1010100', '11:15:00', '12:05:00'),
('1010100', '12:20:00', '13:10:00'),
('1010100', '13:25:00', '14:15:00'),
('1010100', '14:30:00', '15:20:00'),
('1010100', '15:35:00', '16:25:00'),
('1010100', '16:40:00', '17:30:00'),
('1010100', '18:00:00', '19:15:00'),
('1010100', '19:30:00', '20:45:00');

-- Monday, Wednesday
INSERT into timeperiod(days, start_time, end_time) 
values ('1010000', '08:00:00', '09:55:00'), 
('1010000', '14:30:00', '15:45:00'),
('1010000', '16:00:00', '17:15:00');

-- Tuesday, Thursday
INSERT into timeperiod(days, start_time, end_time) 
values ('0101000', '08:00:00', '08:55:00'),
('0101000', '09:05:00', '10:20:00'),
('0101000', '10:35:00', '11:50:00'),
('0101000', '12:05:00', '13:20:00'),
('0101000', '13:35:00', '14:50:00'),
('0101000', '15:05:00', '16:20:00'),
('0101000', '16:35:00', '17:50:00'),
('0101000', '18:00:00', '19:15:00'),
('0101000', '19:30:00', '20:45:00');

INSERT into Faculty(PSU_ID, Last_Name, First_Name, Major_College, Employment_Type)
values ('qry323', 'Snaps', 'Ginger', 'IST/SRA', 'Tenure'),
('crm13', 'Maurer', 'Clifford', 'IST/SRA', 'Full-Time'),
('auk3', 'Konak', 'Abdullah', 'IST/SRA', 'Full-Time'),
('tkc3', 'Clark', 'Tricia', 'IST/SRA', 'Tenure'),
('yxx78', 'Xue', 'Yuan', 'IST/SRA', 'Tenure'),
('dzl5300', 'Liu', 'Daonian', 'IST/SRA', 'Tenure'),
('mxn16', 'Nasereddin', 'Mahdi', 'IST/SRA', 'Full-Time'),
('whb108', 'Bowers', 'William', 'IST/SRA', 'Part-Time'),
('mrb24', 'Bartolacci', 'Michael', 'IST/SRA', 'Part-Time'),
('sxk70', 'Kulturel-Konak', 'Sadan', 'IST/SRA', 'Tenure'),
('jkb20', 'Burk', 'Jill', 'CAS', 'Full-Time'),
('cln12', 'Cheryl', 'Nicholas', 'CAS', 'Full-Time'),
('kmm410', 'Williams', 'Kesha', 'CAS', 'Part-Time'),
('cdc18', 'Catanach', 'Catherine', 'CAS', 'Part-Time'),
('msr332', 'Ramsay', 'Michele', 'CAS', 'Tenure'),
('dpr15', 'Reitz', 'Dawn', 'CAS', 'Tenure'),
('amir.barakati', 'Barakati', 'Amir', 'Engineering', 'Full-Time'),
('aue10', 'Panah', 'Azar', 'Engineering', 'Tenure'),
('kms122', 'Hauser', 'Kathleen', 'Engineering', 'Full-Time');

INSERT into Room(Room_ID, Building, Occupancy, Num_of_Computers, Lab_Type)
values ('208', 'Gaige', 30, 30, 'Computer'),
('207', 'Gaige', 25, 20, 'Computer'),
('210', 'Gaige', 25, 20, 'Computer'),
('209', 'Gaige', 20, 20, 'Computer'),
('218', 'Gaige', 45, 0, 'Lecture'),
('110', 'Gaige', 30, 1, 'Lecture'),
('120', 'Luerrson', 20, 20, 'Computer'),
('013', 'Luerrson', 40, 1, 'Lecture'),
('210', 'Luerrson', 15, 2, 'Fluid');

INSERT into Course(Sub, Course_Num, course_name, Description, Units)
values ('IST', '110','Information, People and Technology', 'Test Description for IST 110', 3),
('SRA', '111','Introduction to Security and Risk Analysis', 'Test Description for SRA 111', 3),
('IST', '210','Database Software', 'Test Description for IST 210', 3),
('IST', '220','Networking Technology', 'Test Description for IST 220', 3),
('SRA', '211','Threat of Terrorism and Crime', 'Test Description for SRA 211', 3),
('IST', '140','Intro to Python', 'Test Description for IST 140', 3),
('IST', '242','Intermediate Object Oriented Programming', 'Test Description for IST 242', 3),
('CAS', '100A','Intro to Communication Arts and Sciences', 'Test Description for CAS 100A', 3),
('CAS', '100B','Intro to Communication Arts and Sciences', 'Test Description for CAS 100B', 3),
('CAS', '100C','Intro to Communication Arts and Sciences', 'Test Description for CAS 100C', 3);

INSERT into ProfessorTimePref(TimePeriod_Period, Faculty_PSU_ID)
values ('1', 'crm13'),
('2', 'auk3'),
('1', 'auk3'),
('3', 'auk3'),
('3', 'kms122'),
('4', 'kms122'),
('1', 'qry323'),
('2', 'qry323'),
('4', 'whb108'),
('6', 'dpr15'),
('5', 'tkc3'),
('2', 'tkc3'),
('3', 'jkb20');
