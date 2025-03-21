package org.howard.edu.lsp.midterm.question5;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * Represents audiobook content in the streaming service.
 * In addition to the common actions, audiobooks can change playback speed.
 */
public class Audiobook extends AbstractStreamable {

    /**
     * Constructs a new Audiobook instance with the given title.
     * 
     * @param title The title of the audiobook.
     */
    public Audiobook(String title) {
        super(title);
    }
    
    @Override
    protected String getMediaType() {
        return "audiobook";
    }
    
    /**
     * Adjusts the playback speed of the audiobook.
     * 
     * @param speed The new playback speed multiplier (e.g., 1.5 for 1.5x speed).
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}
