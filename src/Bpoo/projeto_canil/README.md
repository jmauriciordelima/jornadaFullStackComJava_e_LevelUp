
---

# 🐕 Sistema de Gerenciamento de Canil

## Sobre o projeto

Sistema desenvolvido em Java para controle e gerenciamento de um canil. O foco do projeto foi a aplicação de conceitos
de **Orientação a Objetos (POO)** e **Arquitetura em Camadas**, garantindo a separação entre a lógica de negócio, a
persistência de dados e a interface com o usuário.

## Funcionalidades

- **CRUD de Cachorros**: Adicionar, listar, buscar e remover cachorros.
- **Persistência**: Salvamento e carregamento automático de dados via arquivos de texto.
- **Estatísticas**: Cálculo de idade média, identificação de animais mais velhos/novos e filtros por fase da vida.
- **Interatividade**: Menu intuitivo via console com tratamento de erros de entrada.

## Tecnologias Utilizadas

- Java 17+
- Manipulação de arquivos (java.io)
- Estruturas de dados (ArrayList, Streams API)

## Arquitetura do Projeto

O sistema foi estruturado para facilitar a manutenção e escalabilidade:

- `modelo`: Entidades de negócio (`Cachorro`).
- `repositorio`: Gerenciamento de persistência de dados.
- `servico`: Lógica de negócio e processamento de estatísticas.
- `util`: Ferramentas de interface e formatação.

## Como Executar

1. Certifique-se de ter o JDK instalado.
2. Clone o repositório.
3. Compile e execute a classe `Main.java`.
4. O sistema criará o arquivo `canil.txt` na raiz do projeto para salvar os dados.

---
*Projeto concluído como parte da mentoria de desenvolvimento Java.*