# PROJETO BIBLIOTECA || PUCPR || 2021
## INTRODUÇÃO

Projeto da matéria de Programação Orientada à Objetos (POO), do curso de Engenharia de Computação na PUCPR. Para este projeto, será utilizada a linguagem de programação Java.

## REQUISITOS

- **cadastrar item:** efetua o cadastro de um novo item cujo idItem é gerado automaticamente (baseado na quantidade de itens de alItem), incluindo os atributos de Item (título) e da subclasse específica que está sendo cadastrada (no caso de um Livro, o autor e o total de páginas, para as Classes C e Y, depende da modelagem da equipe); 


- **cadastrar amigo:** efetua o cadastro de um novo amigo cujo idAmigo é gerado automaticamente (baseado na quantidade de amigos de alAmigos), incluindo o atributo nomeAmigo;


- **emprestar:** o sistema pergunta o código do item a ser emprestado (atributo idItem), depois qual o amigo (pode mostrar todos para escolher o código do amigo, ou fazer busca pelo nome para identificar e pegar código). Efetua o empréstimo na data corrente com objeto da classe Emprestimo incluído no alEmprestimos. Ou seja, idAmigo empresta item idItem em dataEmprestimo colocando dispItem em Item para Disponibilidade.Emprestado;


- **devolver:** o sistema pergunta o código do item a ser emprestado (atributo idItem), e efetua a devolução deste Item que estava fora, ou seja aquele objeto cujo idItem indica que está emprestado. Ao devolver um item, não remover o objeto de alEmprestimos (que portanto conterá empréstimos já concluídos – um histórico, e os empréstimos em andamento);


- **listar empréstimos atuais:** o sistema mostra todos os items emprestados: seu título, quem pegou e em que data pegou emprestado (para isso percorre o alEmprestados identificando quem está fora, ou seja, dispItem igual Disponibilidade.Emprestado);


- **listar histórico de empréstimos:** o sistema pergunta o código de um item (idItem) e lista todas as movimentações daquele item, ou seja, todos os empréstimos já feitos (quem, data empréstimo e data devolução) e o empréstimo atual (se existir) para aquele item em particular;


- **listar biblioteca:** o sistema mostra todos os items ordenados pelo seu título em ordem alfabética ascendente, mostrando o título do item e sua situação (dispItem);


- **alterar estado:** o sistema pergunta o código de um item (idItem) e permite mudar sua disponibilidade para Consulta Local (se não estive Emprestado), ou Danificado ou Extraviado (independente de estar anteriormente Disponível ou Emprestado).
