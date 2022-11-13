# how to build
```$xslt
1. manage project module

2. mvn clean install

3. mv jar to sonar extensions/plugins

4. restart sonar
```

# how to add a new rule
```$xslt
1. add RuleClass class like org.sonar.samples.java.checks.MyFirstCustomCheck
2. register RuleClass in org.sonar.samples.java.RulesList
3. add html in resources/org.sonar.l10n.java.rules.java
4. add json in resources/org.sonar.l10n.java.rules.java
```
