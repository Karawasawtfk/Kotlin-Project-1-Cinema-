# Kotlin-Project-1-Cinema-
My first Kotlin project based on Hyperskill 'Kotlin Core' course.

Basically it's a very simple cinema model.

1. You define the size of the cinema hall (number of rows and seats).
2. Then you are presented to a menu with 3 possible options:
  - print the visual representation of the cinema (each seat is printed as a 'S' or 'B' symbol (B is used for booked seats);
  - buy a ticket by specifying its row and number. If the seat is already booked, you are offered to choose another seat;
  - print some statistics. Just print it, it speaks for itself;
  - exit (abort the execution).
3. Every action you perform brings you back to the menu (except for the <Exit> option).

It's not perfect even for this small number of scenarios. You might get stuck in a loop if all the seats are booked or simply input values that will cause an exception.
Moreover, it lacks comments and constants. Also I guess its design is lame but I'm gonna leave it as is for now.
I will try to make more concise and stable code in the next projects.
