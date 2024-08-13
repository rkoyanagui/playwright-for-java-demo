# language: pt
Funcionalidade: Sauce Demo

  Cenário: Login com usuário comum
    Dado que abro o sítio do Sauce Demo
    Quando entro as credenciais de acesso de usuário comum
    Então deve-se exibir os produtos e o ícone de carrinho de compras

  Cenário: Login com usuário bloqueado
    Dado que abro o sítio do Sauce Demo
    Quando entro as credenciais de acesso de usuário bloqueado
    Então deve-se exibir o erro de usuário bloqueado
