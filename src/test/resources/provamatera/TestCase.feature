# language: pt

Funcionalidade: Calculadora Triangulo


  Cenário: Calcular Triângulo Isósceles informando valores iguais nos Campos "Lado1" e "Lado2"
    Dado que preenchi o campo lado1 com o valor "1"
    E preenchi o campo lado2 com o valor "1"
    Mas que preenchi o campo lado3 com o valor "2"
    Quando clicar no botão Calcular
    Então o sistema exibirá a mensagem "Triângulo Isósceles" e sua imagem

  Cenário:Calcular Triângulo Equilátero
    Dado que preenchi o campo lado1 com o valor "5"
    E preenchi o campo lado2 com o valor "5"
    E que preenchi o campo lado3 com o valor "5"
    Quando clicar no botão Calcular
    Então o sistema exibirá a mensagem "Triângulo Equilátero" e sua imagem

  Cenário: Calcular Triângulo Equilátero
    Dado que preenchi o campo lado1 com o valor "3"
    E preenchi o campo lado2 com o valor "5"
    E que preenchi o campo lado3 com o valor "8"
    Quando clicar no botão Calcular
    Então o sistema exibirá a mensagem "Triângulo Escaleno" e sua imagem

  Cenário: Validar campos nulos
    Dado que não preechi nenhum campo
    Quando clicar no botão Calcular
    Então o sistema exibirá a mensagem "Preencha todos os lados"

  Cenário: Validar somente números
    Dado que preenchi o campo lado1 com o valor "E.,+-"
    E preenchi o campo lado2 com o valor ".,e"
    E que preenchi o campo lado3 com o valor "e+-"
    Quando clicar no botão Calcular
    Então o sistema exibirá a mensagem "Insira um número"



