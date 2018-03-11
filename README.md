# MarsExplorerProject
1. Input is created using objects in Junit test.
2. Ideally in real scenario implementation, I would have liked to get the inputs from either reading file/command line.
But as part of this assignment I have focused on implementing the main functionality and writing tests around them.
3. We can use Java 8 features also for implementation like iterating using for-each.
4. MarsSurface, top Right Input Parameters are validated at the start of creating MarsSurface Object
5. Before adding command to Robot, the validation is done if the passed in instructions are valid
(Ideal Scenario would have been when the input would be read, that time instructions should be converted to Commands
and then Robot instance should be created.)
6. Converting String Instructions to Commands just performs conversion as validation for instruction string is done earlier.

