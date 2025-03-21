package org.howard.edu.lsp.midterm.question5;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * Provides a common implementation for shared streaming behaviors.
 * This abstract class supports playing, pausing, and stopping content.
 */
public abstract class AbstractStreamable implements Streamable {
    protected String title;

    /**
     * Constructs a new streamable media with the given title.
     * 
     * @param title The title of the media.
     */
    public AbstractStreamable(String title) {
        this.title = title;
    }

    /**
     * Returns the media type (e.g., "music", "movie", "audiobook").
     * Subclasses should override this to provide the correct type.
     * 
     * @return A string representation of the media type.
     */
    protected abstract String getMediaType();

    @Override
    public void play() {
        System.out.println("Playing " + getMediaType() + ": " + title);
    }

    @Override
    public void pause() {
        System.out.println("Paused " + getMediaType() + ": " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopped " + getMediaType() + ": " + title);
    }
}
