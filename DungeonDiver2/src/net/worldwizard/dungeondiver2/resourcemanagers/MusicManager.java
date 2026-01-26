/*  DungeonDiverII: A Map-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package net.worldwizard.dungeondiver2.resourcemanagers;

import java.net.URL;
import java.nio.BufferUnderflowException;

import org.retropipes.diane.asset.ogg.DianeOggPlayer;

import net.worldwizard.dungeondiver2.DungeonDiver2;

public class MusicManager {
    private static final String DEFAULT_LOAD_PATH = "/net/worldwizard/dungeondiver2/resources/music/";
    private static String LOAD_PATH = MusicManager.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = MusicManager.class;
    private static DianeOggPlayer CURRENT_MUSIC;

    public static void playMusic(final int musicID) {
	String filename = MusicConstants.MUSIC_NAMES[musicID];
	final URL url = MusicManager.LOAD_CLASS.getResource(MusicManager.LOAD_PATH + filename.toLowerCase() + ".ogg");
	MusicManager.CURRENT_MUSIC = DianeOggPlayer.loadLoopedResource(url);
	if (MusicManager.CURRENT_MUSIC != null) {
	    // Play the music
	    MusicManager.CURRENT_MUSIC.start();
	}
    }

    public static void stopMusic() {
	if (MusicManager.CURRENT_MUSIC != null) {
	    // Stop the music
	    try {
		DianeOggPlayer.stopPlaying();
	    } catch (BufferUnderflowException bue) {
		// Ignore
	    } catch (NullPointerException np) {
		// Ignore
	    } catch (Throwable t) {
		DungeonDiver2.logError(t);
	    }
	}
    }

    public static boolean isMusicPlaying() {
	if (MusicManager.CURRENT_MUSIC != null) {
	    if (MusicManager.CURRENT_MUSIC.isPlaying()) {
		return true;
	    }
	}
	return false;
    }
}