/*  SceneMaker: A Map-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package net.worldwizard.support.creatures.races;

import java.io.File;

import org.retropipes.diane.fileio.DataIOFactory;
import org.retropipes.diane.fileio.XDataReader;

import net.worldwizard.support.Support;
import net.worldwizard.support.SystemLoader;
import net.worldwizard.support.variables.Extension;

public class RaceLoader {
    // Constructors
    private RaceLoader() {
	// Do nothing
    }

    // Methods
    public static Race loadRace(final String file) {
	if (file.startsWith("$")) {
	    return SystemLoader.loadRace(file);
	} else {
	    try (final XDataReader raceFile = DataIOFactory.createTagReader(Support.getVariables().getBasePath()
		    + File.separator + "races" + File.separator + file + Extension.getRaceExtensionWithPeriod(),
		    Extension.getRaceExtension())) {
		final Race r = Race.read(raceFile);
		raceFile.close();
		return r;
	    } catch (final Exception ex) {
		Support.logError(ex);
		return null;
	    }
	}
    }
}
