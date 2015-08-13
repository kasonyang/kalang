package ${packageName};
public interface OpVisitor{
    <#list ops as p>
        public void visit${p.name}(<#list p.params as pp>${pp.type} ${pp.name}<#sep>,</#list>);
    </#list>
}