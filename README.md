Wrestling Tournament Management System

Overview
The Wrestling Tournament Management System is a Java-based application designed to manage and simulate wrestling tournaments. It follows an Object-Oriented Programming (OOP) approach
and incorporates design patterns such as the Builder Pattern (for Wrestler creation) and Singleton Pattern (for tracking winners and tournament status). 
The system includes a structured tournament format, point-based rankings, and match simulations.

Tournament Structure : 

First Level: 10 One-on-One matches across two arenas
Top 4 Selection: Based on points table ranking
Semi-Finals: Two simultaneous matches to determine the 3rd and 4th place wrestlers
Knockout Stage: Two simultaneous matches to determine finalists
Final Match: Championship match between top 2 wrestlers

Point System :
Win: +2 Points
Loss: +1 Point

Special Moves Mechanism :
Wrestlers can execute a "Power Move" when attacking twice in a row

Design Patterns Used
Builder Pattern: Used for flexible and controlled Wrestler creation.
Singleton Pattern: Used for managing the tournament state and tracking winners.

Technologies Used : 
Java (Object-Oriented Programming)
Multithreading for simultaneous match execution

How to Run :

Clone the repository:

git clone https://github.com/yourusername/wrestling-tournament.git

Navigate to the project directory:

cd wrestling-tournament

Compile the project:

javac -d bin src/**/*.java

Run the application:

java -cp bin MainClass
