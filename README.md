# playwright-for-java-demo

Demonstração de como usar a ferramenta de teste [Playwright](https://playwright.dev/java/) com Java.

É preciso ter instalado:

* [JDK 17](https://github.com/adoptium/temurin17-binaries/releases/tag/jdk-17.0.12%2B7)
* [Maven](https://maven.apache.org/install.html).

Usou-se o [Cucumber](https://cucumber.io/) para descrever os testes.

Usou-se o [saucedemo.com](https://www.saucedemo.com/) como sítio de exemplo.

Para executar:

```shell
mvn test
```

Para executar em paralelo, por exemplo, em duas threads:

```shell
mvn test -Dthreadcount=2
```

Para ver o resultado, inclusive com vídeo-evidência, abre este arquivo em um navegador qualquer:
`target/report/cucumber-html-reports/overview-features.html`
