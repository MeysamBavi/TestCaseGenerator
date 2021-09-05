## Example
So here's a programming question:

> Sum the two integers in the input and print out the result.  
>   
> Input example  
> ``11 16``  
> 
> Output example  
> ``27``

The solution app that gives the correct answer is the `solution.py` python script.  
Let's assume we want `/src/ProblemOne` directory to be our 'main' directory; so it needs to be the `WorkingDirectory`.  
And also assume `solution.py` is stored in `/src/ProblemOne` path. `ProblemOne.java` is how you would use `TestCaseGenerator`;  
  
You can see that `python solution.py` command is run directly because the script is stored in `WorkingDirectory`,  
and `InputsDirectory` and `OutputsDirectory` are written relative to `WorkingDirectory` (absolute paths are valid as well).
