package org.howard.edu.lsp.midterm.question3;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * The VotingMachineTest class serves as the driver for testing the VotingMachine implementation.
 * It demonstrates adding candidates, casting valid and invalid votes, and displaying the election results.
 */
public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates to the voting system
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes for the candidates
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempting to cast a vote for a candidate not registered
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);

        // Displaying the winner with the total number of votes
        System.out.println("Winner: " + vm.getWinner());
    }
}
