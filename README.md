# 💣 Campo Minado em Java

Projeto de implementação do clássico jogo **Campo Minado**, desenvolvido com **Java puro** utilizando a biblioteca gráfica **Swing**.

## 🧩 Funcionalidades

- Interface gráfica com `JFrame` e `JPanel`
- Grade 10x10 com 100 células (`JButton`)
- Sorteio aleatório de **10 bombas**
- Clique com o botão **esquerdo** revela :
  - 💣 Mostra bomba se clicou em uma
  - Mostra a quantidade de bombas por perto
- Clique com o botão **direito** marca com 🚩
- Alerta de **"Você perdeu!"** ao clicar em bomba

## 🎮 Como jogar

1. Execute o programa
2. Clique nas células com o **botão esquerdo** para revelar
3. Use o **botão direito** para marcar suspeitas com 🚩
4. Clicou em uma bomba? 💥 Game over!

## 📦 Tecnologias usadas

- **Java 8+**
- **Swing (javax.swing)**
- **GridLayout**
- **MouseListener / MouseAdapter**

## 🧑‍💻 Como executar

1. Copie o código-fonte `CampoMinado.java` em seu projeto
2. Compile:
   ```bash
   javac CampoMinado.java

Projeto feito por [LeonardoVictorMuller](https://github.com/LeonardoVictorMuller) e [JoãoVitorSchmitt](https://github.com/joaovs2004)
