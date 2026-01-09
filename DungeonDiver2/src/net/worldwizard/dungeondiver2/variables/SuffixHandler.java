package net.worldwizard.dungeondiver2.variables;

import java.io.IOException;

import org.retropipes.diane.fileio.XDataReader;
import org.retropipes.diane.fileio.XDataWriter;

import net.worldwizard.dungeondiver2.DungeonDiver2;
import net.worldwizard.support.map.SuffixIO;

public class SuffixHandler implements SuffixIO {
    @Override
    public void readSuffix(final XDataReader reader, final int formatVersion) throws IOException {
	DungeonDiver2.getApplication().getGameManager().loadGameHookX(reader);
    }

    @Override
    public void writeSuffix(final XDataWriter writer) throws IOException {
	DungeonDiver2.getApplication().getGameManager().saveGameHookX(writer);
    }
}
