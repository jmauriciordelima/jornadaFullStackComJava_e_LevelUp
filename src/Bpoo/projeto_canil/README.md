# 🐕 Sistema de Gerenciamento de Canil

Sistema desenvolvido em **Java puro** para gerenciamento de um canil via terminal.
Projeto construído com foco em **Orientação a Objetos** e **arquitetura em camadas**,
aplicando boas práticas de design de software desde a concepção.

---

## 📋 Funcionalidades

| Opção | Funcionalidade |
|-------|----------------|
| `[1]` | Adicionar cachorro (com validação de entrada) |
| `[2]` | Listar todos os cachorros |
| `[3]` | Buscar cachorro por nome |
| `[4]` | Remover cachorro |
| `[5]` | Registrar aniversário (incrementa idade) |
| `[6]` | Exibir estatísticas do canil |
| `[7]` | Filtrar cachorros por fase da vida |
| `[8]` | Identificar cachorro mais velho e mais novo |
| `[9]` | Salvar dados em arquivo |
| `[0]` | Sair (com opção de salvar) |

---

## 🏗️ Arquitetura

O projeto foi estruturado em camadas com responsabilidades bem definidas:

```
src/
└── Bpoo/
    └── projeto_canil/
        ├── modelo/
        │   ├── Cachorro.java          # Entidade de negócio
        │   └── FaseVida.java          # Enum de classificação etária
        │
        ├── repositorio/
        │   └── CanilRepository.java   # Persistência e acesso a dados
        │
        ├── servico/
        │   └── CanilService.java      # Regras de negócio e estatísticas
        │
        ├── util/
        │   └── MenuUtil.java          # Interface e formatação visual
        │
        └── Main.java                  # Ponto de entrada e orquestração
```

### Fluxo de comunicação entre camadas:

```
Main (orquestrador)
  ├── MenuUtil        → exibição de menus e mensagens
  ├── CanilRepository → operações CRUD e persistência
  └── CanilService    → estatísticas e regras de negócio
        └── usa CanilRepository internamente
```

---

## 🛠️ Tecnologias e Conceitos Aplicados

**Linguagem:** Java 17+

**Orientação a Objetos:**
- Encapsulamento com `private` e getters/setters
- Múltiplos construtores com sobrecarga e encadeamento via `this()`
- Métodos de instância e auxiliares privados
- Separação de responsabilidades entre classes
- Enum (`FaseVida`) para type safety na classificação etária
- Sobrescrita de `toString()`, `equals()` e `hashCode()`
- Identidade de objetos baseada em ID único sequencial

**Gerenciamento de ID:**
- ID sequencial gerado e controlado pelo `CanilRepository`
- Persistência do contador entre execuções via leitura do arquivo
- Garantia de unicidade sem reaproveitamento de IDs removidos

**Java I/O:**
- `FileWriter` + `BufferedWriter` + `PrintWriter` para escrita
- `FileReader` + `BufferedReader` para leitura
- `try-with-resources` para gerenciamento automático de recursos

**Coleções:**
- `ArrayList<Cachorro>` para armazenamento em memória
- Algoritmos de busca de máximo/mínimo em coleções de objetos
- Filtragem de listas por critério com type safety via Enum

**Tratamento de Erros:**
- `try-catch` com `NumberFormatException` para validação de entrada numérica
- `IOException` para operações de arquivo

---

## ▶️ Como Executar

**Pré-requisitos:** JDK 17 ou superior instalado.

```bash
# Clone o repositório
git clone <url-do-repositorio>

# Navegue até o diretório
cd projeto-canil

# Compile
javac -d out src/Bpoo/projeto_canil/**/*.java src/Bpoo/projeto_canil/Main.java

# Execute
java -cp out Bpoo.projeto_canil.Main
```

> **Nota:** Na primeira execução, o arquivo `canil.txt` será criado automaticamente
> na raiz do projeto ao salvar dados. Nas execuções seguintes, os dados são
> carregados automaticamente ao iniciar.

---

## 📊 Exemplo de Uso

```
╔════════════════════════════════╗
║    SISTEMA DE CANIL - MENU     ║
╠════════════════════════════════╣
║ [1] Adicionar Cachorro         ║
║ [2] Listar Todos os Cachorros  ║
...
╚════════════════════════════════╝

→ 6

╔════════════════════════════════╗
║     ESTATÍSTICAS DO CANIL      ║
╚════════════════════════════════╝
TOTAL DE CACHORROS: 3
IDADE MÉDIA: 4.7
MAIS VELHO: MAX (12 ANOS)
MAIS NOVO: BOB (1 ANO)
FILHOTES: 1
ADULTOS: 1
IDOSOS: 1
```

---

## 📁 Formato do Arquivo de Persistência

Os dados são salvos em `canil.txt` com o seguinte formato CSV:

```
1;REX;LABRADOR;3;
2;BOB;POODLE;5;
3;MAX;VIRA-LATA;12;
```

Campos: `id;nome;raca;idade`

> O ID é sequencial e persistido entre execuções. Ao reiniciar o programa,
> o sistema identifica o maior ID existente e continua a sequência a partir dele.

---

## 🎓 Contexto de Desenvolvimento

Este projeto foi desenvolvido como parte de uma **jornada de aprendizado em Java**,
cobrindo os seguintes marcos:

- Fundamentos de Java (loops, condicionais, Scanner)
- ArrayList e algoritmos de manipulação de coleções
- Programação Orientada a Objetos do zero ao avançado
- Enum e type safety
- Sobrescrita de `toString()`, `equals()` e `hashCode()`
- Gerenciamento de identidade de objetos com ID sequencial
- Arquitetura em camadas e separação de responsabilidades
- Persistência de dados com File I/O
- Tratamento de exceções
- Boas práticas: Clean Code, Javadoc, encapsulamento, nomenclatura

O sistema evoluiu incrementalmente ao longo do processo, com cada funcionalidade
sendo implementada, revisada e refatorada — refletindo o ciclo real de desenvolvimento
de software profissional.

---

## 👨‍💻 Autor

José Maurício
Desenvolvedor Java em formação

🔗 [GitHub](https://github.com/jmauriciordelima/jornadaFullStackComJava_e_LevelUp/tree/main/src/Bpoo/projeto_canil)

🔗 [LinkedIn](https://www.linkedin.com/in/jmauriciorlima/)