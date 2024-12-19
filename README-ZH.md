# 项目名称

[English Documentation](README.md)

## 项目亮点
- **DSL 转换为 SpEL**：将自定义 DSL 表达式转换为 Spring 表达式语言 (SpEL)。
- **动态方法调用**：支持动态调用 Java 方法和 Groovy 脚本。

## 特性
- **逻辑表达式解析**：解析和评估带有自定义条件的逻辑表达式。
- **函数调用**：支持在表达式中调用函数。
- **字面量处理**：处理表达式中的字符串和数字字面量。
- **动态 Groovy 脚本执行**：在表达式中动态执行 Groovy 脚本。

## 快速启动
1. **克隆仓库**：
    ```sh
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```

2. **使用 Maven 构建项目**：
    ```sh
    mvn clean install
    ```

3. **运行应用程序**：
    ```sh
    mvn exec:java -Dexec.mainClass="com.ze.gao.App"
    ```

4. **示例用法**：
    - 修改 `App.java` 中的 `input` 字符串以测试不同的 DSL 表达式。
    - 运行应用程序以查看转换后的 SpEL 及其对 `Contract` 对象的影响。

## 许可证
此项目使用 MIT 许可证。详情请参阅 [LICENSE](LICENSE) 文件。