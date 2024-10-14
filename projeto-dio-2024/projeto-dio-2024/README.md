# Santander APP
Repositório criado para aprendizado da Framework Spring em java


## Diagrama de classes

``` mermaid
classDiagram
  class Usuario{
  -String nome
  -Conta conta
  -Cartao cartao
  -Features[] features
}

  class Conta{
  -String numero
  -String agencia
  -Int numero
  -Int limite
}

  class Cartao{
  -String numero
  -Int limite
}

  class Features{
  -String icone
  -String descricao
}

  class Extras{
  -String icone
  -String descricao
}

Usuario "1" *-- "1" Conta
Usuario "1" *-- "1" Cartao
Usuario "1" *-- "1..N" Features
Usuario "1" *-- "1..N" Extras

```


