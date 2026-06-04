package dev.kwlew.kskills.core.hooks.papi;

import dev.kwlew.kskills.core.info.Info;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPI extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return Info.PLUGIN_NAME;
    }

    @Override
    public @NotNull String getAuthor() {
        return Info.AUTHOR;
    }

    @Override
    public @NotNull String getVersion() {
        return Info.VERSION;
    }

    @Override
    public boolean persist() {
        return true;
    }
}
