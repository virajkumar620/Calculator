Simple Swing Calculator
A simple, functional desktop calculator built using Java's Swing GUI toolkit. This project provides a clean user interface for performing basic arithmetic operations.

Description
This is a straightforward calculator application created in Java. It demonstrates the use of Swing components like JFrame, JTextField, JButton, and layout managers like GridLayout to build an interactive user interface. The calculator handles addition, subtraction, multiplication, and division, along with decimal points and basic error handling for division by zero.

Features
Basic Arithmetic: Perform addition (+), subtraction (-), multiplication (*), and division (/).

User-Friendly Interface: A classic calculator layout that is intuitive and easy to use.

Number & Decimal Support: Includes buttons for digits 0-9 and a decimal point (.).

Clear and Delete:

C (Clear): Resets the entire calculation and clears the display.

Del (Delete): Removes the last character from the current input.

Error Handling: Prevents division by zero and displays an "Error" message.

Prerequisites
To compile and run this project, you only need to have the Java Development Kit (JDK) installed on your system. No external libraries are required, as Swing is part of the standard Java library.

JDK 8 or a later version.

How to Run
You can run this application directly from the command line.

Save the Code:
Save the provided source code into a file named Calculator.java.

Open a Terminal:
Navigate to the directory where you saved Calculator.java.

Compile the Code:
Use the Java compiler (javac) to create the bytecode file.

Bash

javac Calculator.java
Run the Application:
Use the java command to execute the compiled code.

Bash

java Calculator
The calculator window should now appear on your screen.

Code Overview
Calculator.java: This single file contains all the code for the application.

Class Calculator: Extends JFrame to create the main window and implements ActionListener to handle button clicks.

Constructor Calculator(): Sets up the GUI components, including the display field, number buttons, function buttons, and the main panel. It uses null layout for precise component placement and GridLayout for the button grid.

actionPerformed(ActionEvent e): This method contains all the logic for what happens when a button is pressed. It checks which button was the source of the event and updates the display or performs calculations accordingly.