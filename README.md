# 💣 Campo Minado em Java

Projeto de implementação do clássico jogo **Campo Minado**, desenvolvido com **Java puro** utilizando a biblioteca gráfica **Swing**. O projeto foi criado com fins didáticos e para praticar lógica, estruturas gráficas e integração com serviços externos.

---

## 🧩 Funcionalidades

- Interface gráfica usando `JFrame`, `JPanel` e `JButton`
- Grade de **10x10** (100 células)
- Quantidade de bombas **dependa da deficuldade que você escolhe**
- Clique com o **botão esquerdo**:
  - 💣 Revela a bomba (caso tenha clicado em uma)
  - Mostra o número de bombas vizinhas
- Clique com o **botão direito**:
  - Marca a célula com 🚩 (suspeita de bomba)
- Mensagem de "💥 Você perdeu!" ao clicar em bomba
- Verificação automática de vitória (todas células seguras abertas)

---

## 🏆 Modo Competitivo

O jogo agora possui um modo **Competitivo**, onde o objetivo é vencer o Campo Minado no menor tempo possível.

- Inicie clicando no botão **"Competitivo"**
- O cronômetro inicia automaticamente
- Ao vencer:
  - O jogador insere seu nome
  - O tempo é enviado para um **ranking online**
- Os dados são registrados em uma planilha Google via integração com `Google Apps Script`
### [Planilha organizada do menor para o maior tempo](https://docs.google.com/spreadsheets/d/1Z-tCbUBxynPq8s4reqgHOqvzfFzms0z_GKEBRqObZkk/edit?usp=sharing)
---

## 🎮 Como jogar

1. Execute o programa
2. Clique nas células com o **botão esquerdo** para revelar
3. Use o **botão direito** para marcar bombas suspeitas com 🚩
4. Clicou em uma bomba? 💥 Game over!
5. No modo competitivo, tente terminar o jogo no menor tempo possível!

---

## 📦 Tecnologias usadas

- **Java 8+**
- **Swing (javax.swing)**
- **GridLayout**
- **MouseListener / MouseAdapter**
- **HttpURLConnection** (para envio de dados)
- **Google Apps Script** (integração com Google Sheets)
- [Notion](https://www.notion.so/Projeto-campo-minado-230a29ffe2cf809f90b3f002f1664f9f)

---

## 🧑‍💻 Como executar

1. Baixe ou clone este repositório
2. Compile o código-fonte:
   ```bash
   javac CampoMinado.java

Projeto feito por [LeonardoVictorMuller](https://github.com/LeonardoVictorMuller) e [JoãoVitorSchmitt](https://github.com/joaovs2004)
