# Kalang
A toy compiler front-end

# Features

* static type safe
* jvm compatible
* auto type
* java source output

# How to build

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

    >kalang SOURCE_DIR OUTPUT_DIR

# IDE support

Netbeans [Kalang-support](https://github.com/kasonyang/kalang-support)
