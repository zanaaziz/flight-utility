# Ryanair Utility Tool Java Project
The "Ryanair Utility Tool" is a college Java project that is built to somewhat mimick a flight recording system. Using this app, you can add, delete, edit, and filter through a "database" of flight records.

# How Does It Work?
Upon launch, the app will search for a 'data.txt' file which would contain all the flight data for it to read and import. It reads the file by using a format of splitting whenever it reads '//'. This indicates that the following information is to be imported into the next cell in the current row.

Of course, it would also save and write to that file using the same format.

<img src="https://github.com/zanadaniel/ryanair-project/blob/master/images/Data%20File.png" width="600">

---

# Flight ID Search Window
This is the first window to greet the user. From here, they can search for a flight using their uniquely generated five digit flight ID that starts with the letter 'F'. Upon search, the program will scan through the data file and if a match is found, display all information back to the user. However, if no match is found, it'll notify the user accordingly.

<img align="left" src="https://github.com/zanadaniel/ryanair-project/blob/master/images/Flight%20ID%20Searching.png" width="600">
<img align="right" src="https://github.com/zanadaniel/ryanair-project/blob/master/images/Flight%20ID%20Search%20Result.png" width="200">

---

# Admin Panel
The admin panel is where the power of the program really is. Here, you can manipulate, create, delete, and sort through the flight records dynamically. The UI is aimed to emphasize efficiency and effectiveness. It's important that a tool such as this is more on the functional side rather than the pretty side.

<img src="https://github.com/zanadaniel/ryanair-project/blob/master/images/Admin%20Panel.png" width="600">

---

# Creating a New Flight Record
Creating a new flight record is really easy. Click the 'Add' button and a window will appear where you can fill in the new flight record details such as where is the flight from and to where, departure and arrival dates, and the times. Also, the program will then instantly calculate the flight duration using the given dates and times.

<img src="https://github.com/zanadaniel/ryanair-project/blob/master/images/Add%20Flight.png" width="600">