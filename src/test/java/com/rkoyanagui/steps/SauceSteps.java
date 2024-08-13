package com.rkoyanagui.steps;

import com.rkoyanagui.pages.InventoryPage;
import com.rkoyanagui.pages.LoginPage;
import com.rkoyanagui.utils.World;
import io.cucumber.java.pt.E;

public class SauceSteps {

    private final World world;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;

    public SauceSteps(World world, LoginPage loginPage, InventoryPage inventoryPage) {
        this.world = world;
        this.loginPage = loginPage;
        this.inventoryPage = inventoryPage;
    }

    @E("que abro o sítio do Sauce Demo")
    public void navigateToSauceDemo() {
        world.getPage().navigate("https://www.saucedemo.com/");
    }

    @E("entro as credenciais de acesso de usuário comum")
    public void loginAsStandardUser() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @E("entro as credenciais de acesso de usuário bloqueado")
    public void loginAsBlockedUser() {
        loginPage.login("locked_out_user", "secret_sauce");
    }

    @E("deve-se exibir os produtos e o ícone de carrinho de compras")
    public void verifyInventoryPageLoaded() {
        inventoryPage.verifyPageLoaded();
    }

    @E("deve-se exibir o erro de usuário bloqueado")
    public void verifyUserBlockedErrorMessage() {
        loginPage.verifyErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }
}
