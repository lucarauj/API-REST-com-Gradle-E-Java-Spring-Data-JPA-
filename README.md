[![NPM](https://img.shields.io/npm/l/react)](https://github.com/lucarauj/API-REST-com-Gradle-E-Java-Spring-Data-JPA-/blob/main/LICENSE)

<h1 align="center"> API REST com Gradle-Groovy e Java: Spring Data JPA </h1>

<p align="center"><img width="700px" src="https://github.com/lucarauj/assets/blob/main/Gradle-Java.jpg" /></p>

<br>

### 🛑 [Projeto base 🖱 ](https://github.com/lucarauj/API-REST-com-Gradle-E-Java)

<br>

### ✅ Implementações:

- Inseri os métodos ```Update - Author```, ```Delete - Author```, ```Get by Id - Author```;
- Além disso, implementei uma regra para que quando o usuário tente excluir um Author que esteja relacionado com algum livro, retorne a seguinte mensagem: "Author is related to a Book";
- Se o usuário informar algum ID de um Author ou Book que não existe no banco de dados nos métodos ```Get by Id```, ```Update```, ```Delete```, ```Post Book {id Author}```, terá como resultado: "Author not found" ou "Book not found";

<br>

### 📝 Novas Anotações:

- @AllArgsConstructor: fornece a criação de um construtor com todos os atributos;
- @Column(nullable = false): usada para definir a restrição na coluna do banco de dados e garante que a coluna não possa ter valores nulos no banco de dados;
- @Data: gera getters para todos os campos, setters para todos os campos não-finais e o toString apropriado, equals e implementações hashCode que envolvem os campos da classe;
- @DeleteMapping: usada para mapear solicitações HTTP DELETE em métodos manipuladores específicos;
- @Entity: utilizada para informar que uma classe também é uma entidade;
- @GeneratedValue(strategy = GenerationType.UUID): indica que a geração do valor do identificador único da entidade será gerenciada pelo provedor de persistência, utilizando a estratégia UUID;
- @GetMapping: usada para mapear solicitações HTTP GET em métodos manipuladores específicos;
- @Id: especifica o identificador da entidade, que é usado ao carregar a entidade em um determinado contexto de persistência;
- @JoinColumn: usada para definir o mapeamento físico real no lado proprietário em uma relação um-para-muitos/muitos-para-um;
- @JsonIgnoreProperties: indica quais propriedades de um objeto devem ser ignoradas durante a serialização ou desserialização;
- @ManyToOne: indica que temos um relacionamento muitos-para-um;
- @NoArgsConstructor: gera um construtor sem argumentos para a classe anotada;
- @OneToMany: indica que temos um relacionamento um-para-muitos;
- @PutMapping: usada para mapear solicitações HTTP PUT em métodos manipuladores específicos;
- @PostMapping: usada para mapear solicitações HTTP POST em métodos específicos de manipulador;
- @RequestBody: indica que o valor do objeto virá do corpo da requisição;
- @Repository: serve para definir uma classe como pertencente à camada de persistência;
- @Table: usada para especificar a tabela principal da entidade atualmente anotada;

<br>

## Créditos 👇

Vitor Medeiro - [MEDEIRO.TECH](https://www.youtube.com/@medeirotech)

<br>

## Aluno

Lucas Araujo

<a href="https://www.linkedin.com/in/lucarauj"><img alt="lucarauj | LinkdeIN" width="40px" src="https://user-images.githubusercontent.com/43545812/144035037-0f415fc7-9f96-4517-a370-ccc6e78a714b.png" /></a>
