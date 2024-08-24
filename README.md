
# Integrative Task 2 - Discrete Structures and Computing II

## Description

This repository contains the implementation and experimentation of error detection algorithms, specifically **Checksum** and **Cyclic Redundancy Check (CRC)**, as part of the Integrative Task 2 for the course Discrete Structures and Computing II.


## Team: Students Of Programing And Software (SOPAS)

### Members:

- Ricardo Andres Chamorro Martinez - A00399846
- Oscar Stiven Muñoz Ramirez - A00399922
- Diego Armando Polanco Lozano - A00399926
- Luis Manuel Rojas Correa - A00399289

## Integrating Task 2
**Terminal Objectives

Terminal Objectives
OT1. Apply the functional paradigm in the analysis, design, evaluation, selection and implementation of algorithms to solve problems whose structure is naturally self-contained.
OT3. Apply fundamental concepts of number theory in the analysis of computational problems that require it, and . analyze binary relations, in particular, those that form an equivalence relation or order relation and apply this concept to the solution of problems.
OT4. Express or communicate with appropriate/specialized vocabulary and language the main ideas about discrete structures or functional programming.

[**Link to statement**](https://docs.google.com/document/d/14JzjEBc079L0GOjIsGlpNOyqZuj_5wyM/edit)

## Implementation

### Programming Languages

- **Scala:** For implementing the functional programming paradigm and error detection algorithms.
- **Java:** For measuring execution time and handling large data sets in the experiments.

### Part 1: Error Detection Algorithms

- **Checksum:** Implementation of an algorithm that calculates a numerical value based on a data set to detect errors during transmission or storage.
- **Cyclic Redundancy Check (CRC):** Implementation of an algorithm that uses a generator polynomial to detect accidental changes or errors in transmitted data.

### Part 2: Experimentation

Experiments were designed and executed to measure the execution time of the algorithms with different data sizes:
- **Toy:** \(n < 10^2\)
- **Small:** \(10^2 < n < 10^4\)
- **Medium:** \(10^4 < n < 10^5\)
- **Large:** \(n > 10^6\)

The implemented classes include:
- **Data Generation**
- **Execution Time Measurement**
- **Experimentation Data Collection**

### Results Analysis

The results of the experimentation are analyzed and compared with the theoretical complexity of the algorithms. Graphs are generated to represent the relationship between input size and execution time, as well as the function that best fits this data. The analysis includes questions that guide the interpretation of the results and the identification of patterns in the experimental versus theoretical complexity.

## Methodology

- **TDD (Test-Driven Development):** The implementation was developed using TDD to ensure code quality.
- **Quality Indicators:** The following indicators were monitored:
  - **Error-Failure Density:** total failures / total tests.
  - **Reliability:** 1 - failure density.
  - **Completeness:** test cases / total functionalities.

## Deliverables

The deliverables for the task include:
- Implementation of Checksum and CRC algorithms.
- Analysis and experimentation report.
- Graphs and comparison with theoretical complexity.
- Project documentation in the `doc/` folder.

## Sources and References

- **Checksum, Wikipedia:** Available at [Wikipedia](https://en.wikipedia.org/wiki/Checksum).
- **Koopman, Philip (2023):** "An Improved Modular Addition Checksum Algorithm." Available at [arXiv](https://arxiv.org/abs/2304.13496).
- **Example Project, OBJECT SETS:** Ángela Villota Gómez. Available at [GitHub](https://github.com/Bloque-CED/objSets).

