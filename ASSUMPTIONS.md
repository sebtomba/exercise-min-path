# Assumptions

## Input source
The application expects the input from the standard input.
An improvement would be to introduce a command line argument to read from a file

## Input format
The application expects as input a complete triangle of numbers.
The whole purpose of the application is to operate on such a triangle.

I assumed that the numbers are 32 bit integers. This is an arbitrary design choice.

## Output format
The application prints the minimal path to standard output.
An improvement would be to implement a command line argument to chose between a minimal and a maximal path.

## Assembly format
For the sake of simplicity only a JAR can be deployed.

## No general purpose implementation
The algorithm is not implemented with type parameters.
It would be possible to abstract over the node values and over the result case class which uses a sum of node values.
