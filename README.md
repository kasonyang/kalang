[![Build Status](https://travis-ci.org/kasonyang/kalang.svg?branch=master)](https://travis-ci.org/kasonyang/kalang)

# Kalang
A toy compiler front-end

# Features

* static type safe
* jvm compatible
* auto type
* java source output and class file output

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

More examples could be found in [examples](https://github.com/kasonyang/kalang/tree/master/examples) directory.

# Usage

add the path`build/install/kalang/bin` to your `PATH` environment variable,and run

    >kalang SOURCE_FILE 

For example:`kalang Helloworld.kl` would compile `Helloworld.kl` in current directory.

More usages please run

    >kalang -h


#TODOs

* add javadoc
* add more test

#License

MIT