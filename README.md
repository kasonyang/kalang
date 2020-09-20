![Maven Central](https://img.shields.io/maven-central/v/site.kason.kalang/kalang-compiler.svg)
[![Build Status](https://travis-ci.org/kasonyang/kalang.svg)](https://travis-ci.org/kasonyang/kalang)
[![Codecov](https://img.shields.io/codecov/c/github/kasonyang/kalang.svg)](https://codecov.io/gh/kasonyang/kalang)

Language: English [切换至中文](README.zh_CN.md)

# Overview

Kalang is a static type-safe language base on jvm with flexible syntax.

# Features

* Powerful scripting mode
* Auto type
* Dependency manager integration
* Static type-safe
* Flexible syntax
* Compatible with other jvm-based languages like java,groovy and so on.

# Installation

### For Linux/Mac users:

    wget -O kalang-compiler-1.10.0.tar http://search.maven.org/remotecontent?filepath=site/kason/kalang/kalang-compiler/1.10.0/kalang-compiler-1.10.0.tar
    tar -xvf kalang-compiler-1.10.0.tar
    ln -s `pwd`/kalang-compiler-1.10.0/bin/kalangc /usr/local/bin/kalangc
    ln -s `pwd`/kalang-compiler-1.10.0/bin/kalangsh /usr/local/bin/kalangsh
    ln -s `pwd`/kalang-compiler-1.10.0/bin/kalangeditor /usr/local/bin/kalangeditor

### For Windows users:

1. Download the latest binary distribution:[http://search.maven.org/remotecontent?filepath=site/kason/kalang/kalang-compiler/1.10.0/kalang-compiler-1.10.0.zip](http://search.maven.org/remotecontent?filepath=site/kason/kalang/kalang-compiler/1.10.0/kalang-compiler-1.10.0.zip)
2. Unzip the downloaded zip file
3. Add the absolute path of the `bin` directory to the `PATH` environment variable

# Make kalang script files executable

Linux:

1. Use `#!/usr/bin/env kalangsh` as the first line of your kalang script file.
2. Use `chmod +x` to make the file executable.
    
Windows:

 Run the following commands in Command Prompt(cmd.exe)
    
```bat
assoc .kls=KalangScript 
ftype KalangScript=kalangsh.bat "%1" %*
```

# Hello World

Created the file named `hello.kls` with the follow content:
 
     println("Hello,world!");

Then run in the terminal:

    kalangsh hello.kls

# Syntax

See [Syntax](docs/syntax.md)

# Usage

## Launch kalang scripts

```
kalangsh YOUR_SCRIPT_FILE YOUR_SCRIPT_ARGUMENTS
```

## Launch kalang compiler

```
kalangc SOURCE_FILE
```

For example:`kalangc Helloworld.kl` would compile `Helloworld.kl` in the current directory.

## Get more usages

```
kalangsh --help
kalangc --help
kalangeditor --help
```

# Dependency manage

You can declare you dependencies in kalang scripts.Kalang shell will resolve the dependencies and download the related files automatically when executing.

For example:
```
#repository http://maven.aliyun.com/nexus/content/groups/public/
#dependency site.kason:color-console:1.0.0

import site.kason.colorconsole.ColorConsole;
var console = ColorConsole.getDefault();
console.info("Hello,world!");
```

# Build from source

Requirements:

* jdk8

Clone the source,and run

    ./gradlew build
    
# Projects writing in kalang

* [dbutil](https://github.com/kasonyang/dbutil) - database utilities
* [ksh](https://github.com/kasonyang/ksh) - script helpers
* [fhc](https://github.com/kasonyang/fhc) - A http client library with fluent api
* [kailer](https://github.com/kasonyang/kailer) - a mailer
* [color-console](https://github.com/kasonyang/color-console) - make output in console colorful

# Gist

* [serve static content](https://gist.github.com/kasonyang/f3d8364161144b0c49f9caf3a7b42272)

#IDE/Editor plugin support

* Intellij Idea : [intellij-kalang](https://github.com/kasonyang/intellij-kalang)
* Visual Studio Code : [kalang-support-for-vscode](https://github.com/kasonyang/kalang-support-for-vscode) (only syntax highlighting)
* NetBeans : [kalang-nb-support](https://github.com/kasonyang/kalang-nb-support)

# License

MIT

please visit [http://kalang.kason.site](http://kalang.kason.site) for more information.
