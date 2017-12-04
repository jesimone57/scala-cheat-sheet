// A Scala implementation of the rock, paper, scissors games
// To compile:
//    scalac rockpaperscissors.scala
// To run:
//    scala rockpaperscissors
//
// Sample output:
// Player 1 choose rock, paper or scissors?
// scissors
// Player 1 chose scissors
// 
// Player 2 choose rock, paper or scissors?
// pap
// Player 2 choose rock, paper or scissors?
// paper
// Player 2 chose paper
// 
// Player 1 wins because scissors beats paper


object rockpaperscissors extends App {

    val choices = Set("rock", "paper", "scissors")
    val wins = Set(("rock", "scissors"), ("paper", "rock"), ("scissors", "paper"))

    def getPlayerInput(player: Int) = {
        var choice: String = ""
        while (! choices.contains(choice)) {
            println("Player %d choose rock, paper or scissors?".format(player))
            choice = scala.io.StdIn.readLine().trim.toLowerCase
        }
        println("Player %d chose %s \n".format(player, choice))
        choice
    }

    val player1 = getPlayerInput(1)
    val player2 = getPlayerInput(2)

    if (wins.contains((player1, player2))) {
        println("Player 1 wins because %s beats %s".format(player1, player2))
    } else if (wins.contains((player2, player1))) {
        println("Player 2 wins because %s beats %s".format(player2, player1))
    } else {
        println("It's a tie.  You'll have to play again because both players choice %s".format(player1))
    }

}
