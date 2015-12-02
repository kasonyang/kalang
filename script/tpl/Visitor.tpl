package {{package}};

public class {{name}}<T> extends {{parent}}<T> implements {{interface}}<T>{
    {{#each nodes}}
    @Override
    public T visit{{this}}({{this}} node){
        this.visitChildren(node);
    }
    {{/each}}
}