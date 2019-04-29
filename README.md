# LionPlanner by Uninventive Softworks

## LionPlanner Motivation:
LionPlanner was developed for the purpose of abolishing the previous analog method of scheduling used by the Resistrar at Penn State University: Berks Campus. The previous analog method involved the use of a whiteboard and constant human communication to determine the possible schedule, which lead to issues with efficiency and human communication error. LionPlanner streamlines this with a simple to follow GUI which allows better organization of data and efficiency for the registrar when scheduling. For other users such as the Professors, a calendar view is available to make visualizing course and make changes based off preferences easy.

## Installation:

You must have a Java compiler installed as well as Github for the Desktop. Some common Java compilers include [GNU](https://www.gnu.org/home.en.html), which was in the IDE [Netbeans](https://netbeans.org/downloads/8.0.2/) we used for Lionplanner.

Github for Desktop can be downloaded [here.](https://desktop.github.com/)

Run the application once it is downloaded.

## Application Guide

Currently, Lionplanner only supports the view for the Registrar. As such, the ability to insert new data for Faculty, Rooms, Courses, and the Final Course Assignment (schedule). This data is inserted into the MySQL Database specified in the SQL Connection Information.

The [Administrative UI] can be located at the top left of the application window.

### File
Allows the user to import / export [XML] files.

Also contains copyright info.

### New
This is for data entry portion of the project. This is where new Faculty, Course, Room, and Final Assignment can be inserted into the database. 

### Data
This is where the data inserted from [New] or the data imported from [File] can be viewed.

### Calendar View
This is where the user can view the Final Course Assignment entries in a calendar view.

### SQL
This is where the user connects to the MySQL database. 

## Instruction

1. Specify the database located under [SQL]
    -This allows the other functions in the [Administrative UI] to be used.

2. If data was not imported under [File] than add data via the [Data] tab for the appropriate categories as needed, though it is recommended to at least have one entry for Faculty, Course, Room, and Final Course Assignment.

3. After a Final Course Assignment is generated, go to [Calendar View] to see any Final Course Assignment schedule in a Calendar View.

## Contributing

Pull requests are always welcome for LionPlanner. 
Major changes need to be addressed first by opening an an issue to discuss what you would like to see changed.

Please make sure to update tests as appropriate. 

## Roadmap / Future Plans

In the future, we hope that Lionplanner accomodate for every campus of Penn State University.
- Lehigh Valley
- Brandywine
- Greater Allegheny
- University Park
- Abington
- Altoona
- Harrisburg
- York
- Scranton
- DuBois
- New Kensington
- Beaver
- Fayette
- Mont Alto
- Schuylkill
- Hazleton
- Wilkes-Barre
- Shenango

We also will accomplish the viewing options for Professors and Students.

## Authors

A special thanks to our development team for authoring Lionplanner.
