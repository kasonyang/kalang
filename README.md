[![Build Status](https://travis-ci.org/kasonyang/kalang.svg?branch=master)](https://travis-ci.org/kasonyang/kalang)

# Kalang
A toy compiler front-end

# Features

* static type safe
* jvm compatible
* auto type
* java source output

# How to build

requirements: 

* jdk8
* gradle

clone the source,and run

    >gradle installDist

# Helloworld Example

    //Helloworld.kl
    class {
        static void main(String[] args){
            var s = "Hello,world!";
            System.out.println(s);
        }
    }

# Usage

add the path`build/install/kalang/bin` to your `PATH` environment variable,and run

    >kalang [SOURCE_DIR [OUTPUT_DIR]]

or

    >kalang SOURCE_FILE [OUTPUT_DIR]

for example:`kalang Helloworld.kl` would compile `Helloworld.kl` to `Helloworld.java` in current directory.

# IDE support

Netbeans [Kalang-support](https://github.com/kasonyang/kalang-support)

#TODOs

* add javadoc
* add more test

#License

MIT