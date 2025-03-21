package org.howard.edu.lsp.midterm.question5;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * Represents any media content that can be streamed.
 * This interface declares the core streaming actions.
 */
public interface Streamable {
    /**
     * Begins playing the media.
     */
    void play();

    /**
     * Pauses the media playback.
     */
    void pause();

    /**
     * Stops the media playback.
     */
    void stop();
}
