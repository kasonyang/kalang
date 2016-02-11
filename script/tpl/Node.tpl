/*
Don't modify!This file is generated automately.
*/
package {{package}};
import java.util.*;
import kalang.core.*;
public class {{name}} extends {{parent}}{
    {{#each fields}}
    public {{&type}} {{name}};
    {{/each}}
    
    public {{name}}(){
        {{#each listFields}}
            if({{this}} == null) {{this}} = new LinkedList();
        {{/each}}
    }
    
    {{#if fields}}
    public {{name}}({{#fields}}{{#if @index}},{{/if}}{{&type}} {{name}}{{/fields}}){
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
        if({{name}}!=null){
            str += "  {{name}}:" + {{name}}.toString()+"\r\n";
        }
        {{/each}}
        return str+"}";
    }
}