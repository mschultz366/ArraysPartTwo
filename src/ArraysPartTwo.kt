//Program contains supply list for pretzel stand

fun main(args: Array<String>) {

    val pretzelCartSupplies = arrayOf("Dough", "Trays", "Cheese", "Salt", "Napkins")
    val supplyQuantity = arrayOf("33", "250", "4", "3", "500")
    var inventory = arrayOf<Array<String>>()

    inventory += pretzelCartSupplies
    inventory += supplyQuantity


    do {
        println(" -- Pretzel Storage -- ")
        println(" 1.\tDisplay inventory")
        println(" 2.\tModify item")
        println(" 3.\tExit")

        print("\nOption: ")
        val menuChoice = readLine()!!.toInt()

        when (menuChoice) {
            1 -> display(inventory)
            2 -> search(inventory)
            3 -> return
            !in 1..3 -> print("Bad input, try again...")
            else -> print("Error...")
        }
    } while (menuChoice != 3)
}


fun display(inv: Array<Array<String>>) {
    for (i in 0 until inv[0].size) {
        println("Inventory item ${i + 1}: ${inv[0][i]}, quantity: ${inv[1][i]}")
    }
}

fun search(inv: Array<Array<String>>) {
    print("Item # to change: ")
    val item = readLine()!!.toInt() - 1

    print("\nQty change: ")
    val quantity = readLine()!!.toInt()

    print("\nAdding to the inventory or removing( +/- ): ")
    val op = readLine()!!.toString()

    val lastInv = inv[1][item].toInt()

    when (op) {
        "+" -> inv[1][item] = (lastInv + quantity).toString()
        "-" -> if (lastInv - quantity < 0) {
            print("Not enough inventory to remove $quantity items!!\n\n")
            inv[1][item] = "0"}
        else inv[1][item] = (lastInv - quantity).toString()
        else -> print("Nothing done to inventory!!")
    }

    println("Last ${inv[0][item]} quantity: $lastInv")
    print("New ${inv[0][item]} quantity: ${inv[1][item]}\n\n")

}