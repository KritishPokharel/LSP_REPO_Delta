package org.howard.edu.lsp.midterm.question5;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * Represents music content in the streaming service.
 * In addition to the common streaming actions, music supports adding songs to a playlist.
 */
public class Music extends AbstractStreamable {
    
    /**
     * Constructs a new Music instance with the provided title.
     * 
     * @param title The title of the music track.
     */
    public Music(String title) {
        super(title);
    }
    
    @Override
    protected String getMediaType() {
        return "music";
    }
    
    /**
     * Adds the current music track to the specified playlist.
     * 
     * @param playlistName The name of the playlist.
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}
