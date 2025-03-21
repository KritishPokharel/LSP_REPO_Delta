package org.howard.edu.lsp.midterm.question3;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

import java.util.HashMap;
import java.util.Map;

/**
 * The VotingMachine class simulates a simple electronic voting system.
 * It allows candidates to be added, votes to be cast only for existing candidates,
 * and determines the candidate with the most votes.
 */
public class VotingMachine {
    private Map<String, Integer> candidateVotes;

    /**
     * Constructs a new VotingMachine instance and initializes the vote counter.
     */
    public VotingMachine() {
        candidateVotes = new HashMap<>();
    }

    /**
     * Registers a new candidate for the election.
     *
     * @param candidateName The unique name identifying the candidate.
     */
    public void addCandidate(String candidateName) {
        if (!candidateVotes.containsKey(candidateName)) {
            candidateVotes.put(candidateName, 0);
        }
    }

    /**
     * Registers a vote for the specified candidate.
     * <p>
     * This method will only register a vote if the candidate exists in the system.
     * If the candidate is not found, the vote is rejected.
     * </p>
     *
     * @param candidateName The name of the candidate receiving the vote.
     * @return {@code true} if the vote is successfully registered; {@code false} if the candidate does not exist.
     */
    public boolean castVote(String candidateName) {
        if (!candidateVotes.containsKey(candidateName)) {
            return false;
        }
        candidateVotes.put(candidateName, candidateVotes.get(candidateName) + 1);
        return true;
    }

    /**
     * Determines the winning candidate based on the highest vote count.
     * <p>
     * In this implementation, if multiple candidates have the same number of votes,
     * the first candidate encountered with the highest votes is declared the winner.
     * </p>
     *
     * @return A string announcing the winner and the total number of votes received.
     */
    public String getWinner() {
        String winner = "";
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
