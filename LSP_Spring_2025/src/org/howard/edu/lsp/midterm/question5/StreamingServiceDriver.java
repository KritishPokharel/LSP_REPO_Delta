package org.howard.edu.lsp.midterm.question5;
//References used:
//https://www.geeksforgeeks.org/
//https://www.programiz.com/

/**
 * Demonstrates the use of various media types in the streaming service.
 * This driver creates instances of Music, Movie, and Audiobook and tests their common and unique behaviors.
 */
public class StreamingServiceDriver {

    public static void main(String[] args) {
        // Create instances of different media types
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");

        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music common behavior
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        // Test Movie common behavior
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook common behavior
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Test unique behaviors for each media type

        // Test Movie-specific behavior (rewind)
        Movie movieWithRewind = (Movie) movie;
        movieWithRewind.rewind(30);
        System.out.println();

        // Test Audiobook-specific behavior (setPlaybackSpeed)
        Audiobook audiobookWithSpeed = (Audiobook) audiobook;
        audiobookWithSpeed.setPlaybackSpeed(1.5);
        System.out.println();

        // Test Music-specific behavior (addToPlaylist)
        Music musicWithPlaylist = (Music) music;
        musicWithPlaylist.addToPlaylist("Favorites");
        System.out.println();
    }
}
