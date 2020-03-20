# Minimal Path Exercise
Consider the following triangle of numbers
```text
        7
     6    3
   3   8    5
11   2   10   9
```
A path through the triangle is a sequence of adjacent nodes, one from each row, starting from the top.
So, for instance, `7 -> 6 -> 3 -> 11` is a path down the left hand edge of the triangle.
A minimal path is defined as one whose sum of values in its nodes is no greater than for any other path through the triangle.
In this case, `7 + 6 + 3 + 2 = 18` is the minimal path.

## Building the JAR
```bash
> sbt assembly
```

## Running the application
```bash
> cat <<EOF | java -jar target/scala-2.13/min-path-assembly-1.0.jar
  7 8
  6 3
  3 8 5
  11 2 10 9
  EOF
```
