*_[EN](https://github.com/yonyong/sonar-java-custom-plugin/blob/master/README_EN.md) | 中文_*
# 介绍
基于sonar官方提供方式实现自定义sonar插件
# 如何构建
```$xslt
1. 配置好项目结构(重要)

2. mvn clean install

3. 将jar包移动至sonar插件目录下(extensions/plugins/)

4. 重启sonar
```

# 如何自定义一个规则
```$xslt
1. 新增一个自定义规则类 org.sonar.samples.java.checks.MyFirstCustomCheck，编写相应逻辑
2. 在org.sonar.samples.java.RulesList类中注册自定义规则类
3. 在resources/org.sonar.l10n.java.rules.java下新建一个同名的html文件(具体可参考 MyFirstCustomCheck.html)
4. 在resources/org.sonar.l10n.java.rules.java下新建一个同名的json文件(具体可参考 MyFirstCustomCheck.json)
```
