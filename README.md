# Trabalho Prático de Orientção a Objetos

* Unb - Universidade de Brasília
* FCTE - Faculdade de Ciências e Tecnologias em Engenharia
* OO - Orientação a Objetos
* Prof. André Luiz Peron Martins Lanna
* Componentes do grupo:
| Matrícula | Nome                             |
|-----------|----------------------------------|
| 231011041 | Alyssa Werneck Bennett Ferreira  |
| 232000721 | Arthur Feitosa Gonçalves Lima    |
| 222006679 | Eduardo Henrique Coutinho Gurjão |
| 232002000 | Enzo Lopes Ferreira              |
| 232002010 | Erick Ryan Caetano Guimarães     |

**Objetivo:**
Desenvolver um sistema Java que aplique todos os conceitos de orientação a objetos de forma organizada e funicional, incluindo explicitamente os conceitos de modularidade, encapsulamento, herança, polimorfismo e tratamento de exceções personalizadas.

-----

## Desenvolvimento de um Sistema de reserva de espaços físicos em uma Universidade

**Descrição:**
O projeto consiste em uma interface que permita aos professores, servidores técnicos e alunos agendar salas, laboratórios e outros locais de forma organizada e eficiente. Para isso, haverá um *cadastro de usuários*, com perfis específicos com permissões diferentes; um *cadastro de espaços*; um *gerenciador de agendamento*, que deve fornecer ao usuário a disponibilidade do espaço em determinado período a fim de facilitar a escolha do usuário; e, um sistema de *emissão de histórico*, que vai exportar um arquivo TXT com o relatório de utilização de um usuário ou espaço.
m resumo, o sistema de reserva de espaços físicos da universidade precisa ser um recurso completo e fácil de usar, que garanta que todos os usuários possam acessar os espaços necessários sem conflitos e com a maior conveniência possível.

-----

### Requisitos Funcionais:
1. **Cadastro de usuários**
   - Cadastro de Alunos
   - Cadastro de Servidores Administrativos
   - Cadastro de Professores

2. **Cadastro de espaços físicos**
   - Cadastro de salas de aulas
   - Cadastro de laboratórios
   - Cadastro de salas de estudos

3. **Agendamento de espaços físicos pelos usuários**
   - Agendamento de espaço físico por aluno
     - Apenas no horário permitido pelo sistema
     - Apenas em um dia (período de utilização não pode ultrapassar um dia)
   - Agendamento de espaço físico por servidores (administrativos ou professores)
     - Sem restrições em quantidade de dias. 
   - Para todos os usuários: 
     - Não pode sobrepor um agendamento previamente feito. 

4. **Emissão de relatórios de utilização pelos usuários**
   - Relatório de utilização dos espaços para um dado usuário. 
   - Relatório de utilização de cada espaço, durante um determinado periodo, contendo todos os usuários que fizeram agendamento. 

5. **Tratamento de Exceções**
   - Não permitir o cadastro de usuários e espaços com campos errados ou faltantes.
   - Não permitir o cadastro de usuários com a mesma matrícula.
   - Não permitir o agendamento em que regras de agendamento são violadas.

-----

### Requisitos Técnicos:
1. **Classes e Objetos / Atributos e Métodos / Associação entre objetos**
    - [ ] Associações entre classes.
    - [ ] Diagramas de Classes UML
    - [x] Relações de herança
    - [x] Elementos de escopo estático
2. **Ocultação de Informação e Retenção de Estado**
    - [x] Atributos privados com métodos públicos para acesso (*getters/setters*)
    - [x] Acesso direto a elementos definidos em outras classes, ***somente*** em relações de herança
3. **Modularidade**
    - [x] Separação do código em pacotes
4. **Polimorfismo**
    - [ ] **Polimorfismo por sobrescrita**
    - [x] **Polimorfismo por sobrecarga**
    - [ ] Polimorfismo paramétrico
5. **Exceções Personalizadas**
    - [ ] ``HorarioIndisponivelException``
    - [ ] ``DiasExcedidosException``
    - [ ] Outros

-----

### Tecnologias Utilizadas
- **Java SE:** Linguagem de programação utilizada
- **JOptionPane:** Para a interface gráfica utiliza-se a classe de ``javax.swing.JOptionPane``
- **ArrayList:** As operações de armazenamento e manipulação de dados são realizadas com o uso de ArrayList, proporcionando flexibilidade e eficiência no gerenciamento das coleções de dados. Utiliza-se ``java.util.List``
- **Identificador unitário:** Para gerenciamento de dados mais robustos, utiliza-se a classe de ``java.util.UUID`` para garantir a confiabilidade e facilitar a passagem de dados.
- **DateLocalTime:** Para os dados de data e horários, utiliza-se a biblioteca de ``java.time``
