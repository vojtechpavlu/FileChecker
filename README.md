# FileChecker
Java-based library providing checking the files against the given schemes.

---

- [FileChecker](#filechecker)
  * [Introduction](#introduction)
  * [Main packages](#main-packages)
    + [core](#core)
    + [containers](#containers)
    + [crawlers](#crawlers)
    + [utils](#utils)
  * [Examples](#examples)
    + [Check file against a rule](#check-file-against-a-rule)
    + [List all files](#list-all-files)
    + [Check file againt multiple rules](#check-file-againt-multiple-rules)
      - [Using Unary-container](#using-unary-container)
      - [Using Multi-container](#using-multi-container)
    + [Complex file check against a container](#complex-file-check-against-a-container)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>


---

## Introduction

This lib allows checking large file sets against the given rules. Using the most general interface **FileCheck** let's you test given files and returns a simple answer - true or false.
Using many predefined tests you can group files by it's size, name, access, suffix or type. For listing files in a path, there are some *directory crawlers* predefined to make it as easy as possible.



## Main packages

There a few main packages groupping a specific set of functionalities together, as follows


### core

In this package, you find a set of predefined tests and the interface - **FileCheck**, which is mutual parent for the most of the classes through the library.

For example, the most general classes are **MaxFileSizeCheck**, **IsDirectoryCheck**, **CanReadCheck** and so on. These are implementations of the FileCheck and override a method of 
*public boolean check(File file) throws IOException* and the default method *public boolean check(String filepath) throws IOException*, which just calls the implemented one creating 
a new java.io.File instance and passing it to the *check(File)* method.


### containers

These are special kinds of checks - these provides testing of:

  - Single check
  - Multiple checks
  
This provides a functionality of control the test flow. The most common unary check (single check) is a *NOTContainer*. 
This one negates the result of the check this container seals.

Other one (Multiple checks) provides functionality of testing a given file against multiple test at once. The combination of test provides only one aggregated result.
For example *ANDContainer* and *ORContainer*.



### crawlers



### utils



## Examples


### Check file against a rule




### List all files



### Check file againt multiple rules

#### Using Unary-container

#### Using Multi-container



### Complex file check against a container




