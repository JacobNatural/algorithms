# Java Algorithms Collection
![Static Badge](https://img.shields.io/badge/Build-passing-flat)
[![Static Badge](https://img.shields.io/badge/Coverage-99%25-flat)](https://jacobnatural.github.io/algorithms/jacoco/index.html)
[![Static Badge](https://img.shields.io/badge/docs-blue)](https://jacobnatural.github.io/algorithms/apidocs/index.html)

## Overview
Welcome to the Java Algorithms Collection! This repository houses various basic algorithms organized into different packages to facilitate learning and exploration.

## Getting Started


### Prerequisites

- **Java Development Kit (JDK) 22+**
- **Apache Maven 3.9.6+**

### Cloning the repository:
- To clone the repository and navigate into the project directory, run:

```bash
git clone https://github.com/JacobNatural/algorithms.git
cd algorithms
```
### Running Tests
- To execute the tests, use the following command:
```bash
mvn clean test
```

### Integrate into Your Project
- If you want to use this application as a dependency in another Maven project,
  first install it into your local Maven repository by running:
```bash
mvn clean install -DskipTests
```
- Then, you can add the following dependency to your pom.xml file:

```xml
<dependency>
    <groupId>com.app</groupId>
    <artifactId>algorithms</artifactId>
    <version>1.0</version>
</dependency>
```

## Contributing

We welcome contributions to improve the Algorithms. Here's how you can contribute:

1. Fork the repository on GitHub.
2. Make enhancements or fix issues in your forked copy.
3. Submit a pull request to merge your changes into the main repository.

Please ensure your code adheres to our coding standards and is thoroughly tested before submitting a pull request.




