package com.rkoyanagui.utils;

import com.microsoft.playwright.*;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class World implements AutoCloseable {

    private FileSystem fileSystem;
    private Playwright playwright;
    private BrowserType browserType;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    public World() {
        init();
    }

    private void init() {
        fileSystem = FileSystems.getDefault();
        playwright = Playwright.create();
        browserType = playwright.chromium();
        var launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1_000);
        browser = browserType.launch(launchOptions);
        var videosDir = fileSystem.getPath("target").resolve("videos");
        var contextOptions = new Browser.NewContextOptions().setRecordVideoDir(videosDir);
        browserContext = browser.newContext(contextOptions);
        page = browserContext.newPage();
    }

    @Override
    public void close() {
        browserContext.close();
        browser.close();
        playwright.close();
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public Playwright getPlaywright() {
        return playwright;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public Browser getBrowser() {
        return browser;
    }

    public BrowserContext getBrowserContext() {
        return browserContext;
    }

    public Page getPage() {
        return page;
    }
}
