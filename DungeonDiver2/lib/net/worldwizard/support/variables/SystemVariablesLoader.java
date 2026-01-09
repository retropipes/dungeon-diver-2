/*  SceneMaker: A Map-Solving Game
Copyright (C) 2008-2011 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package net.worldwizard.support.variables;

import java.io.File;
import java.io.InputStream;

import org.retropipes.diane.fileio.utility.FileUtilities;
import org.retropipes.diane.fileio.utility.ZipUtilities;

import net.worldwizard.support.Support;

public class SystemVariablesLoader {
    // Constructors
    private SystemVariablesLoader() {
	// Do nothing
    }

    // Methods
    public static void loadSystemVariables() {
	Support.createSystemVariables();
	try (final InputStream sysStream = SystemVariablesLoader.class
		.getResourceAsStream("/net/worldwizard/support/resources/sysdump/core.sysdump")) {
	    final File tempSys = new File(Variables.getTempFolder() + File.separator + "core.sysdump");
	    FileUtilities.copyRAMFile(sysStream, tempSys);
	    ZipUtilities.unzipDirectory(tempSys, new File(Support.getSystemVariables().getBasePath()));
	} catch (final Exception ex) {
	    Support.logError(ex);
	}
    }
}
