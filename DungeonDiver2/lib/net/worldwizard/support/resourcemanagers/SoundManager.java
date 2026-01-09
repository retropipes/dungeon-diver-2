/*  DungeonDiverII: A Map-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package net.worldwizard.support.resourcemanagers;

import java.net.URL;

import org.retropipes.diane.asset.sound.DianeSoundPlayer;
import org.retropipes.diane.random.RandomRange;

import net.worldwizard.support.map.generic.GameSounds;

public class SoundManager {
    private static final String DEFAULT_LOAD_PATH = "/net/worldwizard/support/resources/sounds/";
    private static String LOAD_PATH = SoundManager.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = SoundManager.class;

    public static void playSound(final GameSounds soundID) {
	if (soundID != GameSounds._NONE) {
	    try {
		final String categoryName = SoundNames.SOUND_CATEGORY_NAMES[SoundNames
			.getCategoryIndexFromSoundIndex(soundID.ordinal())];
		final String soundName = SoundNames.SOUND_NAMES[soundID.ordinal()];
		String sfile;
		if (soundName.equalsIgnoreCase("walk")) {
		    final RandomRange r = new RandomRange(1, 2);
		    sfile = soundName + Integer.toString(r.generate());
		} else {
		    sfile = soundName;
		}
		final URL url = SoundManager.LOAD_CLASS
			.getResource(SoundManager.LOAD_PATH + categoryName + "/" + sfile.toLowerCase() + ".wav");
		DianeSoundPlayer.playSource(url);
	    } catch (final ArrayIndexOutOfBoundsException aioob) {
		// Do nothing
	    }
	}
    }
}