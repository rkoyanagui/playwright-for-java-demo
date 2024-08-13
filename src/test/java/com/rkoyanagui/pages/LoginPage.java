package com.rkoyanagui.pages;

import com.microsoft.playwright.Locator;
import com.rkoyanagui.utils.World;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final World world;

    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator errorText;

    public LoginPage(World world) {
        this.world = world;
        var page = this.world.getPage();
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.errorText = page.locator("[data-test='error']");
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public void verifyErrorMessage(String expected) {
        assertThat(errorText).isVisible();
        assertThat(errorText).hasText(expected);
    }
}
