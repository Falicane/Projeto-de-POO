
# 🏆 Projeto Java — Programação Orientada por Objetos

Bem-vindo ao repositório do nosso projeto Java! Este trabalho foi desenvolvido no âmbito da unidade curricular de **Programação Orientada por Objetos** (POO), em 2025.

O objetivo principal foi aplicar de forma prática os conceitos fundamentais da POO, através do desenvolvimento de uma aplicação estruturada, comentada e documentada com **JavaDoc**. Esperamos que este projeto sirva como base de aprendizagem para outros colegas e curiosos da programação!

---

## 👥 Autores

- **Adalgisa Pedro**
- **Tomás Adão**

---

## 🧑‍💻 Como executar no VS Code (forma mais simples)

1. **Instalar o VS Code** e o **Java Extension Pack** (caso ainda não tenhas):
   - [Download do VS Code](https://code.visualstudio.com/)
   - No VS Code, vai a _Extensões_ e instala `Extension Pack for Java` (fornecido pela Microsoft)

2. **Abrir o projeto**
   - Abre o VS Code
   - Vai a `Ficheiro > Abrir Pasta` e seleciona a pasta onde estão os ficheiros `.java`

3. **Correr o programa**
   - Abre o ficheiro `TorneioGUI.java` (onde está o método `main`)
   - Clica no botão `Run` (ícone de play ▶️ que aparece junto à linha `public static void main(...)`)
   - Ou pressiona `Ctrl + F5` para executar

> O VS Code trata automaticamente da compilação e execução dos ficheiros. Muito simples!

---

## 🛠️ Como gerar a documentação JavaDoc

Se quiseres gerar a documentação técnica a partir dos comentários JavaDoc:

### No terminal do VS Code (Linux/macOS/Git Bash no Windows):

```bash
javadoc -d doc $(find . -name "*.java")
```

### No terminal do VS Code (Windows - cmd.exe):

```cmd
for /R %f in (*.java) do @echo %f >> sources.txt
javadoc -d doc @sources.txt
del sources.txt
```

Depois abre o ficheiro `doc/index.html` no navegador para explorares a documentação.

---

## 💡 Objetivos pedagógicos

Este projeto tem como finalidades:

- Consolidar os princípios de **encapsulamento**, **herança**, **polimorfismo** e **abstração**
- Utilizar corretamente **construtores**, **métodos**, **interfaces** e **classes**
- Aplicar boas práticas de organização e documentação de código em Java

---

## 📄 Licença

Este projeto é disponibilizado sob a licença **Creative Commons CC-BY-NC 4.0**.

> Podes reutilizar, adaptar e partilhar, desde que atribuas os créditos e não o utilizes para fins comerciais.

Mais detalhes: [https://creativecommons.org/licenses/by-nc/4.0/](https://creativecommons.org/licenses/by-nc/4.0/)

---

## 🎓 Agradecimentos

A todos os colegas, docentes e recursos educativos que nos ajudaram a compreender a magia da Programação Orientada por Objetos. 👩‍💻👨‍💻

---

🧠 *Feito com empenho, lógica e muitas linhas de código!*
