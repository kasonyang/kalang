/*
Don't modify!This file is generated automately.
*/
package {{package}};
import java.util.*;
public class {{name}} extends {{parent}}{
    {{#each fields}}
    public {{&type}} {{name}};
    {{/each}}
    
    {{#if fields}}
    public {{name}}({{#fields}}{{#if @index}},{{/if}}{{&type}} {{name}}=null{{/fields}}){
        {{#each listFields}}
            if({{this}} == null) {{this}} = new LinkedList();
        {{/each}}
        {{#each fields}}
            this.{{name}} = {{name}};
        {{/each}}
    }
    {{/if}}
    
    public static {{name}} create(){
        {{name}} node = new {{name}}();
        {{#each listFields}}
        node.{{this}} = new LinkedList();
        {{/each}}
        return node;
    }
    
    private void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    private void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        {{#each childFields}}
        addChild(ls,{{this}});
        {{/each}}
        return ls;
    }
    
    public String toString(){
        String str = "{{name}}{\r\n";
        {{#each fields}}
        str += "  {{name}}:" + {{name}}.toString()+"\r\n";
        {{/each}}
        return str+"}";
    }
}