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

<img align="left" src="https://github.com/zanadaniel/ryanair-project/blob/master/images/Flight%20ID%20Search%20Result.png" width="300">