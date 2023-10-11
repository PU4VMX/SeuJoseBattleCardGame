# Jogo de Cartas Colecionáveis em Kotlin
Este é um projeto finalizado de um jogo de cartas colecionáveis desenvolvido em Kotlin como parte do curso de Bacharelado em Sistemas de Informação, disciplina de Programação Mobile. 
O jogo simula a experiência de jogar um jogo de cartas colecionáveis, onde os jogadores constroem seus baralhos personalizados a partir de uma coleção de cartas disponíveis.

## Pré-requisitos
### Ambiente Kotlin

O jogo foi desenvolvido usando usando o ambiente [IntelliJ IDEA](https://www.jetbrains.com/idea/), 
e a JDK "jbr-17.0.8.1", disponível para download dentro do ambiente.


## Descrição do Jogo
Seu José é um apaixonado por jogos de cartas colecionáveis, semelhantes aos conhecidos Magic e Yu-Gi-Oh. Ele deseja compartilhar seu baralho com um amigo (adversário) para se divertir e passar o tempo em boa companhia. 
O jogo consiste em utilizar estratégias para posicionar monstros no tabuleiro, equipá-los com cartas de equipamento e realizar ataques contra o oponente.

## Objetivo
O principal objetivo deste projeto é praticar conceitos relacionados à programação Orientada a Objetos e ganhar experiência na linguagem de programação Kotlin.


## Funcionalidades do Jogo

Durante uma rodada, os jogadores podem escolher entre as seguintes ações:

- **Leitura da Coleção de Cartas:** O programa lê a coleção de cartas a partir de um documento de texto fornecido, contendo informações sobre os monstros e equipamentos disponíveis.
- **Distribuição Inicial de Cartas:** Cada jogador recebe aleatoriamente 5 cartas da coleção para formar sua mão inicial.
- **Posicionamento de Monstros:** Os jogadores podem selecionar monstros da mão e posicioná-los no tabuleiro, com um limite de 5 monstros por jogador. Os monstros podem ser posicionados em estado de ataque ou defesa.
- **Utilização de Equipamentos:** Os jogadores podem equipar seus monstros com cartas de equipamento disponíveis na coleção, aumentando seus atributos.
- **Limite de Cartas na Mão:** Cada jogador pode ter no máximo 10 cartas em sua mão. Caso esse limite seja ultrapassado, o jogador deve descartar cartas suficientes para não exceder o limite.
- **Realização de Rodadas:** O jogo é realizado em rodadas. A cada rodada, os jogadores recebem uma nova carta em suas mãos e escolhem suas ações.
- **Ataques:** Os jogadores podem escolher qual monstro do oponente desejam atacar. A eficácia do ataque depende do estado do monstro atacado (ataque ou defesa).
- **Restrição de Ataque:** Cada monstro posicionado no tabuleiro só pode atacar uma vez a cada rodada.
- **Pontuação e Vitória:** Cada jogador começa com 10000 pontos. O jogo continua até que um jogador atinja 0 pontos ou o baralho não tenha mais cartas. O jogador com a maior pontuação é considerado o vencedor.
- **Dano Direto:** Se um jogador não tiver posicionado nenhum monstro no tabuleiro, seu adversário pode infringir dano direto aos seus pontos a partir da segunda rodada.

## Como executar o jogo
Para executar o jogo, siga os passos abaixo:

- Baixe e instale o ambiente de desenvolvimento Kotlin (se ainda não o tiver).
- Clone este repositório ou faça o download dos arquivos do projeto.
- Abra o projeto em seu ambiente de desenvolvimento Kotlin.
- Execute o programa principal para iniciar o jogo.

## Contribuição

Este projeto foi desenvolvido como parte de um trabalho prático no curso de Bacharelado em Sistemas de Informação, na de disciplina Programação Mobile. Se você deseja contribuir ou aprimorar este projeto, sinta-se à vontade para fazer um fork e enviar suas contribuições.

Esperamos que você aproveite o jogo e tenha muita diversão jogando cartas colecionáveis com seus amigos!
