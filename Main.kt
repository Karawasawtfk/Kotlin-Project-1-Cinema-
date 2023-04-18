import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsInRow = readln().toInt()

    val seatsTable = MutableList(rows) {
        MutableList(seatsInRow) { "S" }
    }

    showMenu(seatsTable)
}

fun showMenu(seatsTable: MutableList<MutableList<String>>) {
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")

    when (readln().toInt()) {
        1 -> showSeats(seatsTable)
        2 -> buyTicket(seatsTable)
        3 -> showStats(seatsTable)
        else -> exitProcess(0)
    }
}

fun showStats(seatsTable: MutableList<MutableList<String>>) {
    var soldTicketsTotal = 0
    var incomeCurrent = 0
    var incomeTotal = 0

    for (i in 0..seatsTable.lastIndex) {
        for (seat in seatsTable[i]) {
            var ticketCost = 10
            if (seatsTable.size * seatsTable[0].size > 60 && i + 1 > seatsTable.size / 2) ticketCost = 8
            incomeTotal += ticketCost

            if (seat == "B") {
                soldTicketsTotal++
                incomeCurrent += ticketCost
            }
        }
    }

    val soldTicketsPercentage = soldTicketsTotal.toDouble() * 100 / (seatsTable.size * seatsTable[0].size)
    println("\nNumber of purchased tickets: $soldTicketsTotal")
    println("Percentage: ${"%.2f".format(soldTicketsPercentage)}%")
    println("Current income: $$incomeCurrent")
    println("Total income: $$incomeTotal\n")

    showMenu(seatsTable)
}

fun showSeats(seatsTable: MutableList<MutableList<String>>) {
    print("\nCinema:\n  ")
    for (i in 1..seatsTable[0].lastIndex + 1) print("$i ")
    println()
    for (i in 1..seatsTable.lastIndex + 1) print("$i ${seatsTable[i-1].joinToString(" ")}\n")

    showMenu(seatsTable)
}

fun buyTicket(seatsTable: MutableList<MutableList<String>>) {
    println("\nEnter a row number:")
    val seatRow = readln().toInt()
    println("Enter a seat number in that row:")
    val seatCol = readln().toInt()

    if (seatRow > seatsTable.size || seatCol > seatsTable[0].size) {
        println("\nWrong input!")
        buyTicket(seatsTable)
    }

    if (seatsTable[seatRow - 1][seatCol - 1] == "B") {
        println("\nThat ticket has already been purchased!")
        buyTicket(seatsTable)
    }
    seatsTable[seatRow - 1][seatCol - 1] = "B"
    val rows = seatsTable.lastIndex + 1
    val seatsInRow = seatsTable[0].lastIndex + 1

    var ticketCost = 10
    if (rows * seatsInRow > 60 && seatRow > rows / 2) ticketCost = 8
    println("\nTicket price: $$ticketCost\n")

    showMenu(seatsTable)
}