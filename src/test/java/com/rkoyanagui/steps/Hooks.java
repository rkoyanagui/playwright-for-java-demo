package com.rkoyanagui.steps;

import com.rkoyanagui.utils.World;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.UUID;

public class Hooks {

    private final World world;

    public Hooks(World world) {
        this.world = world;
    }

    @After
    public void tearDown(Scenario scenario) {
        world.getBrowserContext().onClose(ignore -> attachVideo(scenario));
        world.close();
    }

    private void attachVideo(Scenario scenario) {
        var scenarioName = scenario.getName().replace(" ", "-");
        var mediaType = "video/mp4";
        var page = world.getPage();
        var path = page.video().path();
        byte[] data;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
        page.video().delete();
        var uuid = UUID.nameUUIDFromBytes(data);
        var fileName = scenarioName + "-" + uuid + ".mp4";
        scenario.attach(data, mediaType, fileName);
    }
}
