package com.bla.foo; // aka folders!

class JavaPackageTest {
    public static void main(String[] args) {
        System.out.print("Test");
    }
}

/*
mkdir com
cd com
mkdir bla
cd bla
mkdir foo
cd foo
move ../../../JavaPackageTest.java .
javac JavaPackageTest.java
cd ../../../
java com.bla.foo.JavaPackageTest
*/