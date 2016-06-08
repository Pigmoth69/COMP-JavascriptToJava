**PROJECT TITLE: JS2JAVA
**GROUP: 5JS2JAVA
NAME1: Ana Casimiro, NR1: up201306354, GRADE1: 18, CONTRIBUTION: 25%
NAME2: Daniel Reis, NR2: up201308586, GRADE2: 18, CONTRIBUTION: 25%
NAME3: João Baião, NR3: up201305195, GRADE3: 18, CONTRIBUTION: 25%
NAME4: João Bernardino, NR4: up201305868, GRADE4: 18, CONTRIBUTION: 25%


**SUMMARY:
The tool we developed is meant to convert programs written in (a subset of) JavaScript to Java. It takes a JavaScript file as input and parses its content, generating an Abstract Syntax Tree (Utils). That tree is then used to (re)generate valid code, this time in the Java language. While we know for a fact that it's not realistic to expect our tool to be able to parse all kinds of JavaScript code, we tried to focus on the most basic elements of the language. Thus, it will be possible to convert simple programs that do not depend to much on JavaScript specific features.


**SYNTACTIC AND SEMANTIC ANALYSIS: (Describe how the syntactic error recovery of your tool does work. Does it exit after the first error?)
Converting code form one language to another (in this case from JavaScript to Java) is a really complex process. For that reason, our main concern for this project was not validating the input. The parsing of the provided JavaScript code is done using the Rhino library, from Mozilla, which provides a package with the necessary classes for parsing JavaScript code and generating ASTs. For this reason, we must assume that the input file is well written and contains no errors. If it does, our tool won't work.


**CODE GENERATION: (when applicable, describe how the code generation of your tool works and identify the possible problems your tool has regarding code generation.)
For generating code, out tool must analyze every node of the generated Utils. Following the Visitor design pattern, we implemented a class that is used to visit each ASTNode. This class has the method "print()", which receives a node as argument and behaves differently according to its type (through method overloading). We also use the JavaPoet external library, which helps in creating and formatting the output Java file.


**OVERVIEW:
Basically, our tool parses a JavaSript file, generating an Utils, then traverses it and finally generates the corresponding Java code. To make this process easier and more organized, we used some external libraries:

- Mozilla Rhino (for JavaScript parsing and Utils generation)
- JavaPoet (for Java source file generation)
- json-simple (for working with JSON files)

In the end, the tool produces the file JS2Java.java, which contains a main() method and is, hopefully, fully functional and ready to execute.


**TESTSUITE AND TEST INFRASTRUCTURE: (Describe the content of your testsuite regarding the number of examples, the approach to automate the test, etc.)


**TASK DISTRIBUTION: (Identify the set of tasks done by each member of the project.)
The longest and hardest part of the development of this tool was preparing the Visitor class do deal with all the possible Utils node types. Since most of these types are independent, it was easy to divide tasks evenly, with each member of the group taking care of about 1/4 of those types. Thus, we can say that the group managed to organize itself efficiently.


**PROS: (Identify the most positive aspects of your tool)
The best thing about this tool is the fact that it is actually prepared to deal with a large variety of JavaScript code. From all the possible node types in the ASTs, more than half are treated correctly. This means our tool can actually convert a significant amount of JavaScript code.


**CONS: (Identify the most negative aspects of your tool)
The main flaw of our tool is not being able to automatically determine data types. Right now, the user must always provide an aditional JSON file which specifies all the types for the variablies present in the JavaScript code.


///////////////////////////////////////////////////////////////////////////////////////////

You must upload a zip file including:

-A folder named “src” with the source code (including the sub-folders you may need for the Java packages, javacc files, and other files);

-A folder named “examples” with 5 representative selected test examples that can be used to run your tool; Each example must have a readme.txt file explaining the intention of the example and the expected results.

-A folder named “testsuite” with the examples you have used to test your tool and if possible with the makefiles and scripts used.

-In the case of Java tools: the jar file for your tool (note that your tool must be able to be executed using: java -jar <name of the jar file.jar> followed by the possible options and by the input/output files.

-In the case of command line tools, they must output usage info when executed without arguments.
Other files needed to test and evaluate your tool.
The file README.txt (see below the information you should include in this file);

Please, find below an indication of the content we expect in the README.txt file. Note that you need to include a brief description for each topic.

The presentations will be on June 7 and 8, 2016. Groups able to present their projects before that dates should contact us.

The agenda and the information about the presentations will be sent soon.
Best regards,
João Cardoso
Rui Maranhão


--------------------------------------
Content for the README.txt file: