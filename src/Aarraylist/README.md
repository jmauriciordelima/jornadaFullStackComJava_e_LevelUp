📚 Antes dos exercícios - Conceitos que você VAI precisar:

1️⃣ Método sort() - Ordenação
```java
ArrayList<String> nomes = new ArrayList<>();

nomes.add("CARLOS");
nomes.add("ANA");
nomes.add("BRUNO");

// Ordenar alfabeticamente
nomes.sort(null); // null = ordem natural (A-Z)
System.out.println(nomes); // [ANA, BRUNO, CARLOS]

// Ordenar em ordem reversa
nomes.sort(Collections.reverseOrder());
System.out.println(nomes); // [CARLOS, BRUNO, ANA]
```
---
2️⃣ Método startsWith() - String
```java
String nome = "CARLOS";
nome.startsWith("C"); // true
nome.startsWith("A"); // false
```
---
3️⃣ Contar ocorrências - Loop
```java
String texto = "BANANA";
int contador = 0;

for (char letra : texto.toCharArray()) {
    if (letra == 'A') {
        contador++;
    }
}
System.out.println(contador); // 3

```

---

## 🏋️ EXERCÍCIOS PROGRESSIVOS

### **Exercício 1 - Ordenar a lista** ⭐
**Objetivo:** Adicionar opção no menu para ordenar nomes

**Requisitos:**
1. Adicione opção `6 - Ordenar lista` no menu
2. Crie o método `ordenarLista()`
3. Mostre um submenu:
```

1 - Ordem alfabética (A-Z)
2 - Ordem reversa (Z-A)
3 - Voltar

Após ordenar, mostre a lista ordenada
IMPORTANTE: Não chame o menu recursivamente!

Dica: Use Collections.reverseOrder() para ordem reversa
javaimport java.util.Collections; // Adicione este import

```

---

### **Exercício 2 - Filtrar por letra inicial** ⭐⭐
**Objetivo:** Buscar nomes que começam com uma letra específica

**Requisitos:**
1. Adicione opção `7 - Filtrar por letra` no menu
2. Peça ao usuário uma letra
3. Mostre **todos os nomes** que começam com aquela letra
4. Mostre quantos nomes foram encontrados
5. Se nenhum nome for encontrado, avise o usuário

**Exemplo de saída:**
```

Digite uma letra: C
Nomes encontrados:
1 - CARLOS
2 - CAMILA
Total: 2 nomes

```

**Desafio extra:** Valide se o usuário digitou apenas **uma letra** (não uma palavra)

---

### **Exercício 3 - Estatísticas da lista** ⭐⭐⭐
**Objetivo:** Criar um "painel de estatísticas"

**Requisitos:**
1. Adicione opção `8 - Estatísticas` no menu
2. Mostre:
   - Total de nomes cadastrados
   - Nome mais longo (e quantas letras tem)
   - Nome mais curto (e quantas letras tem)
   - Letra que mais aparece em todos os nomes juntos
   - Quantas vezes essa letra aparece

**Exemplo de saída:**
```

=== ESTATÍSTICAS ===
Total de nomes: 5
Nome mais longo: ALEXANDRE [9 letras]
Nome mais curto: ANA [3 letras]
Letra mais frequente: A (aparece 12 vezes)
Dicas:

Para encontrar o maior/menor, percorra a lista comparando .length()
Para contar letras, use um loop dentro de outro loop
Armazene a contagem em variáveis temporárias