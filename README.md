# 📱 App de Cadastro - Trabalho Bimestral (Android Nativo)

Este é um projeto acadêmico desenvolvido para a disciplina de Desenvolvimento Mobile da Universidade Paranaense (UNIPAR). O aplicativo consiste em um fluxo de cadastro simples de três telas, focando em navegação, tráfego de dados, estruturação clássica de layouts e monitoramento profundo do Ciclo de Vida do Android.

## 🚀 Funcionalidades e Escopo Atendido

* **Tela de Cadastro (MainActivity):** Layout construído com `RelativeLayout` e `LinearLayouts` em cascata. Utiliza teclados específicos (Texto, Numérico e Postal) e validação limpa.
* **Tela de Confirmação (ResultActivity):** Recepção de dados via `Bundle` e devolução de estado de validação ("Sim" ou "Não") utilizando as flags `CLEAR_TOP` e `SINGLE_TOP` para controle de pilha de navegação.
* **Tela Sobre (AboutActivity):** "Capa" do trabalho acadêmico acessível globalmente via `OptionsMenu` (Toolbar) em modo `Always`, contendo dados institucionais e autoria.
* **Auditoria de Ciclo de Vida:** Todos os métodos de transição de estado (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`, `onRestart`) são monitorados e impressos no Logcat no nível `INFO`.

## 🛠️ Tecnologias e Padrões Utilizados

* **Linguagem:** Java
* **Interface (UI):** XML nativo (Android SDK)
* **Design System:** Material Design (Ícones vetoriais embutidos).
* **Paleta de Cores:** Regra das Cores Complementares (Azul `blue_500` como Primária e Laranja `orange_500` como Secundária).
* **Boas Práticas Aplicadas:**
  * **i18n (Internacionalização):** Zero textos *hardcoded*. Toda a tipografia está centralizada no `strings.xml`.
  * **Javadocs:** Documentação técnica rigorosa em todas as classes e métodos principais baseada no padrão Oracle.
  * **Separação de Responsabilidades (SoC):** Lógica isolada nas *Activities* e regras de negócio de UI injetadas exclusivamente via arquivos de *Resources* (`themes.xml`, `colors.xml`).

## ⚙️ Como Executar o Projeto

**Pré-requisitos:** Android Studio atualizado (ou VS Code com SDK tools) e um emulador ou dispositivo físico rodando Android.

1. Clone este repositório:
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
   ```
2. Abra a pasta clonada no **Android Studio**.
3. Aguarde o *Gradle Sync* terminar a indexação das dependências.
4. Selecione o emulador de sua preferência (ex: Pixel 7 API 33+) ou conecte seu dispositivo físico via USB Debugging.
5. Clique no botão de **Run (Play)** ou execute via terminal:
   ```bash
   ./gradlew installDebug
   ```

## 👨‍💻 Autoria

Desenvolvido exclusivamente por:
* **Vinicius Henrique Cordeiro da Silva** - RA: 60002252
* **Curso:** Sistemas de Informação - UNIPAR (5º Período)

