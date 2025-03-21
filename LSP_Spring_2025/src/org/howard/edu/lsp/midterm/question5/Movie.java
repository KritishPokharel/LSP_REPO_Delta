package org.howard.edu.lsp.midterm.question5;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * Represents movie content in the streaming service.
 * Besides the shared streaming functions, movies allow for rewinding.
 */
public class Movie extends AbstractStreamable {

    /**
     * Constructs a new Movie instance with the provided title.
     * 
     * @param title The title of the movie.
     */
    public Movie(String title) {
        super(title);
    }
    
    @Override
    protected String getMediaType() {
        return "movie";
    }
    
    /**
     * Rewinds the movie by the given number of seconds.
     * 
     * @param seconds The number of seconds to rewind.
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}
