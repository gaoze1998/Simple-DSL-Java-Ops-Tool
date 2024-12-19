# Project Name

[中文文档](README-ZH.md)

## Project Highlights
- **DSL to SpEL Conversion**: Convert custom DSL expressions to Spring Expression Language (SpEL).
- **Dynamic Method Invocation**: Support for invoking Java methods and Groovy scripts dynamically.

## Features
- **Logical Expression Parsing**: Parse and evaluate logical expressions with custom conditions.
- **Function Calls**: Support for function calls within expressions.
- **Literal Handling**: Handle string and number literals within expressions.
- **Dynamic Groovy Script Execution**: Execute Groovy scripts dynamically within expressions.

## Quick Start
1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```

2. **Build the project using Maven**:
    ```sh
    mvn clean install
    ```

3. **Run the application**:
    ```sh
    mvn exec:java -Dexec.mainClass="com.ze.gao.App"
    ```

4. **Example Usage**:
    - Modify the `input` string in `App.java` to test different DSL expressions.
    - Run the application to see the converted SpEL and the effect on the `Contract` object.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.