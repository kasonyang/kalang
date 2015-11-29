package {{package}};
public interface {{name}}<T>{
    {{#each nodes}}
    public T visit{{this}}({{this}} node);
    {{/each}}
}