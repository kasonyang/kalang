![Maven Central](https://img.shields.io/maven-central/v/site.kason.kalang/kalang-compiler.svg)
[![Build Status](https://travis-ci.org/kasonyang/kalang.svg)](https://travis-ci.org/kasonyang/kalang)
[![Codecov](https://img.shields.io/codecov/c/github/kasonyang/kalang.svg)](https://codecov.io/gh/kasonyang/kalang)

语言：中文 [Switch to english](README.md)

# 概述

Kalang是一门基于JVM的静态类型安全、语法灵活的编程语言。

# 特性

* 实用的脚本模式
* 自动类型
* 集成依赖管理
* 静态类型安全
* 语法灵活
* 兼容其他基于JVM的语言，如java,groovy等等.

# 安装

### Linux/Mac用户:

    wget -O kalang-compiler-1.10.0.tar http://search.maven.org/remotecontent?filepath=site/kason/kalang/kalang-compiler/1.10.0/kalang-compiler-1.10.0.tar
    tar -xvf kalang-compiler-1.10.0.tar
    ln -s `pwd`/kalang-compiler-1.10.0/bin/kalangc /usr/local/bin/kalangc
    ln -s `pwd`/kalang-compiler-1.10.0/bin/kalangsh /usr/local/bin/kalangsh
    ln -s `pwd`/kalang-compiler-1.10.0/bin/kalangeditor /usr/local/bin/kalangeditor

### Windows用户:

1. 下载最新的二进制包:[http://search.maven.org/remotecontent?filepath=site/kason/kalang/kalang-compiler/1.10.0/kalang-compiler-1.10.0.zip](http://search.maven.org/remotecontent?filepath=site/kason/kalang/kalang-compiler/1.10.0/kalang-compiler-1.10.0.zip)
2. 对下载下来的二进制包进行解压缩。
3. 将解压后的`bin`目录添加到`PATH`系统环境变量里。

# 使kalang脚本文件可以直接执行

Linux:

1. 把 `#!/usr/bin/env kalangsh` 作为脚本文件的首行.
2. 使用 `chmod +x` 命令给文件增加可执行权限.
    
Windows:

 在命令提示符(cmd.exe)下执行如下命令
    
```bat
assoc .kls=KalangScript 
ftype KalangScript=kalangsh.bat "%1" %*
```

# Hello World

创建`hello.kls`文件，并输入如下内容:
 
     println("Hello,world!");

然后在终端中执行:

    kalangsh hello.kls


# 语法

详见 [语法](docs/syntax.md)

# 用法

## 运行kalang脚本文件

```
kalangsh YOUR_SCRIPT_FILE YOUR_SCRIPT_ARGUMENTS
```

## 编译kalang源文件

```
kalangc SOURCE_FILE
```

例如:`kalangc Helloworld.kl` 将编译当前目录下的 `Helloworld.kl`文件.

## 获取更多用法

```
kalangsh --help
kalangc --help
kalangeditor --help
```

# 依赖管理

你可以在kalang脚本中声明你的maven依赖，Kalang shell执行脚本的时候，会自动解析并下载依赖文件。

例如:
```
#repository http://maven.aliyun.com/nexus/content/groups/public/
#dependency site.kason:color-console:1.0.0

import site.kason.colorconsole.ColorConsole;
var console = ColorConsole.getDefault();
console.info("Hello,world!");
```

# 从源码构建

环境要求:

* jdk8

克隆代码到本地，并执行

    ./gradlew build
    
# 使用kalang编写的项目

* [dbutil](https://github.com/kasonyang/dbutil) - 数据库工具类
* [ksh](https://github.com/kasonyang/ksh) - 脚本帮助类
* [fhc](https://github.com/kasonyang/fhc) - 链式API的Http客户端
* [kailer](https://github.com/kasonyang/kailer) - 邮件发送器
* [color-console](https://github.com/kasonyang/color-console) - 控制台支持颜色文字

# Gist

* [静态内容伺服器](https://gist.github.com/kasonyang/f3d8364161144b0c49f9caf3a7b42272)

#编辑器/IDE支持

* Intellij Idea : [intellij-kalang](https://github.com/kasonyang/intellij-kalang)
* Visual Studio Code : [kalang-support-for-vscode](https://github.com/kasonyang/kalang-support-for-vscode) (仅语法高亮)
* NetBeans : [kalang-nb-support](https://github.com/kasonyang/kalang-nb-support)

# 开源协议

MIT

更多信息请访问 [http://kalang.kason.site](http://kalang.kason.site).
