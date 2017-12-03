# Ryanair Utility Tool Java Project
The "Ryanair Utility Tool" is a college Java project that is built to somewhat mimick a flight recording system. Using this app, you can add, delete, edit, and filter through a "database" of flight records.

# How Does It Work?
Upon launch, the app will search for a 'data.txt' file which would contain all the flight data for it to read and import. It reads the file by using a format of splitting whenever it reads '//'. This indicates that the following information is to be imported into the next cell in the current row.