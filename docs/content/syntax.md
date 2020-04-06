title=Kalang syntax
date=2018-10-27
type=post
tags=
status=published
~~~~~~

# Base Syntax

## Package and class name

You don't have to declare package name and class name in the code.Kalang use the directory name as package name and the file name as class name.For example,the file `/src/foo/bar/Helloworld.kl` means that the package name is `foo.bar` , the main class name is `Helloworld` and the full class name is `foo.bar.Helloworld`,if the source root is `/src`.

## Import classes

Import single class:

```
import foo.bar.Helloworld;
```

Import using alias:

```
import foo.bar.HelloKalang as KL;
```

Import all classes in package:

```
import foo.bar.*;
```

## Declare class

define a normal class:

```
//define a class,default modifier is public
class{
    //declare fields and methods
}
```

define a generic class:

```
class<T>{
    //...
}
```

extend and implement:

```
class extends Object implements List<String>{
    //...
}
```

write as a script:

```
println("Hello,world");
```

## Declare method

```
int sum(int a,int b){
    return a+b;
}
```

## Declare variable

Declare a int variable

```
var a = 1;
```

Declare a string variable

```
var b = String.format("%d",2);
```

Declare a immutable int variable

```
val ia = 3;
```

Declare a variable with specified type and initial value

```
var obj as Object = "hello";
```

## Interpolation

```
var name = "kalang";
println( "hello,${name}!" );//output:hello,kalang!
```

## Loop

for loop:

```
for(int i=0;i<9;i++){
    println(i);
}
```

foreach loop

```
for (v in [1,2,3]){
    println("value:${v}");
}
for (v,i in [1,2,3]){
    println("index:${i},value:${v}");
}
```

loop invoke

```
var arr = ["a","ab","abc"];
var lens = arr*.length();//lens will be [1,2,3]
```

while loop:

```
while(expression){
    //do Some Thing
}
```

do loop:

```
do{
//do some thing
}while(expression);
```

## Comments

```
//line comment

/*
multi-line comment
*/

```

## Declare array

```
var intArray = [1,2,3];                    //int[]
var integerArray= <Integer>[1,2,3];        //Integer[]
var stringArray = ["hello","world"];       //String[]
```

```
int[] arr = new int[10];             //length is 10
int[] arr2 = new int[]{1,2,3};       //arr2 is initialized and it's length is 3
```

## Declare map

```
var objectMap = ["name":"kalang","year":2016];          //Map<String,Object>
var stringMap = ["name":"kalang","type":"language"];    //Map<String,String>
var ov = objectMap.get("name");                         //ov is Object type
var sv = stringMap.get("name");                         //sv is String type
```

## Null safe

```
void hello(String? name){
    name.length();           //compile error:name may be null
    if(name!=null){
        name.length();       //compile passed:name is null checked
    }
}
```

## Cast type automatically

```
Object s = "hello";
if(s instanceof String){
    s.chars();//the type of s is changed from Object to String automatically
}
```

## Closures

Closures supports up to 8 parameters.

```
void sayHello(String name,&Void(String) callback) {
    callback("Hello,${name}");
}

sayHello("kalang" , result => println(result));

val sayHi as &Void(String) = (name) => {
    println("Hi,${name}");
};
sayHi("kalang");

```