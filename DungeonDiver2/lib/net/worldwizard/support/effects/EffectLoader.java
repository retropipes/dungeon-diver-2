/*  SceneMaker: A Map-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package net.worldwizard.support.effects;

import java.io.File;

import org.retropipes.diane.fileio.DataIOFactory;
import org.retropipes.diane.fileio.XDataReader;

import net.worldwizard.support.Support;
import net.worldwizard.support.SystemLoader;
import net.worldwizard.support.variables.Extension;

public class EffectLoader {
    // Constructors
    private EffectLoader() {
	// Do nothing
    }

    // Methods
    public static Effect loadEffect(final String file) {
	if (file.startsWith("$")) {
	    return SystemLoader.loadEffect(file);
	} else {
	    try (final XDataReader effectFile = DataIOFactory.createTagReader(Support.getVariables().getBasePath()
		    + File.separator + "effects" + File.separator + file + Extension.getEffectExtensionWithPeriod(),
		    Extension.getEffectExtension())) {
		final Effect e = Effect.read(effectFile);
		effectFile.close();
		return e;
	    } catch (final Exception ex) {
		Support.logError(ex);
		return null;
	    }
	}
    }
}
