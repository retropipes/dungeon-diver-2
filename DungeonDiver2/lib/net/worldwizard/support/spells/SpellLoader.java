/*  SceneMaker: A Map-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package net.worldwizard.support.spells;

import java.io.File;

import org.retropipes.diane.fileio.DataIOFactory;
import org.retropipes.diane.fileio.XDataReader;

import net.worldwizard.support.Support;
import net.worldwizard.support.SystemLoader;
import net.worldwizard.support.variables.Extension;

public class SpellLoader {
    // Constructors
    private SpellLoader() {
	// Do nothing
    }

    // Methods
    public static Spell loadSpell(final String file) {
	if (file.startsWith("$")) {
	    return SystemLoader.loadSpell(file);
	} else {
	    try {
		final XDataReader spellFile = DataIOFactory.createTagReader(Support.getVariables().getBasePath() + File.separator
			+ "spells" + File.separator + file + Extension.getSpellExtensionWithPeriod(),
			Extension.getSpellExtension());
		final Spell s = Spell.read(spellFile);
		spellFile.close();
		return s;
	    } catch (final Exception ex) {
		Support.logError(ex);
		return null;
	    }
	}
    }
}
