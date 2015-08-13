package ${packageName};
import kava.opcode.Op;

public class ${name} extends <#if extend??>${extend}<#else>Op</#if> {
    <#if extend??>
    public ${name}(<#list params as p>${p.type} ${p.name}<#sep>,</#list>){
        super(<#list params as p>${p.name}<#sep>,</#list>);
    }
    <#else>
    <#list params as p>
        public ${p.type} ${p.name};
    </#list>
    public ${name}(<#list params as p>${p.type} ${p.name}<#sep>,</#list>){
        <#list params as p>
            this.${p.name} = ${p.name};
        </#list>
    
    }
    </#if>
    public Object getParameter(String key){
        <#list params as p>
        if(key == "${p.name}") return this.${p.name};
        </#list>
        return null;
    }
    public void setParameter(String key,Object value){
        <#list params as p>
        if(key == "${p.name}"){this.${p.name} = (${p.type})value;return;}
        </#list>
    }
}