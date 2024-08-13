package com.rkoyanagui.pages;

import com.microsoft.playwright.Locator;
import com.rkoyanagui.utils.World;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InventoryPage {

    private final World world;

    private final Locator shoppingCartButton;
    private final Locator titleText;

    public InventoryPage(World world) {
        this.world = world;
        var page = this.world.getPage();
        this.shoppingCartButton = page.locator("#shopping_cart_container");
        this.titleText = page.locator("[data-test='title']");
    }

    public void verifyPageLoaded() {
        assertThat(shoppingCartButton).isVisible();
        assertThat(titleText).isVisible();
        assertThat(titleText).hasText("Products");
    }
}
