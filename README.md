# TestCaseGenerator
A java program to generate test cases for programming problems. Websites like [quera](https://quera.ir/) can use these test cases to judge and grade questions.  
  
It works both on windows and linux.

### How to use
Create a class that implements `ProblemConfigData` interface then use the `generate` method of `TestCaseGenerator` object for generating. You can also simply edit the methods in `MyProblem` class and run `Main`.  
  
Use `run.bat` on Windows and `run.sh` on Linux to compile and run the program.
  
The only 'programming' you need to do here is to override the `generateInput` method; your solution **doesn't** have to be written in java.
