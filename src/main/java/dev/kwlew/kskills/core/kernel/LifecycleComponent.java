package dev.kwlew.kskills.core.kernel;

public interface LifecycleComponent {

    default void init() {}
    default void start() {}
    default void shutdown() {}
}