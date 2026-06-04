package dev.kwlew.kskills.core.kernel;

import dev.kwlew.kskills.core.hooks.bstats.bStatsHook;
import dev.kwlew.kskills.core.hooks.papi.PlaceholderAPIHook;
import dev.kwlew.kskills.listeners.BlockListener;
import dev.kwlew.kskills.listeners.MobHitListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Bootstrap {

    private final Registry registry = new Registry();

    public Bootstrap(JavaPlugin plugin) {
        registry.register(JavaPlugin.class, plugin);
        registry.register(Registry.class, registry);

        initMain();
    }

    public void init() {
        lifecycle(LifecycleComponent::init);
        lifecycle(LifecycleComponent::start);

    }

    public void shutdown() {
        lifecycle(LifecycleComponent::shutdown);
    }

    private void initMain() {
        initListeners();

        initHooks();
    }

    private void initListeners() {
        registry.resolve(MobHitListener.class);
        registry.resolve(BlockListener.class);
    }

    private void initHooks() {
        registry.resolve(bStatsHook.class);

        registry.resolve(PlaceholderAPIHook.class);
    }

    private void lifecycle(Consumer<LifecycleComponent> action) {
        for (Object obj : new ArrayList<>(registry.getAll())) {
            if (obj instanceof LifecycleComponent component) {
                action.accept(component);
            }
        }
    }
}