# Ядро знаний

"Ядро знаний" — это образовательная игра для школьников, разработанная для облегчения понимания
сложных концепций ядерной и атомной физики. В формате популярной игры "Виселица" игрокам 
предлагается угадать научные термины, относящиеся к ядерной физике, технологии, истории 
и безопасности. Игра предназначена как для самостоятельного изучения, так и для использования
в классе под руководством учителя, способствуя активному вовлечению и интересу к теме.



## Структура проекта

Это типовой Java-проект, который собирается с помощью инструмента автоматической
сборки проектов [Apache Maven](https://maven.apache.org/).

Проект состоит из следующих директорий и файлов:

- [pom.xml](./pom.xml) – дескриптор сборки, используемый maven, или Project
  Object Model. В нем описаны зависимости проекта и шаги по его сборке
- [src/](./src) – директория, которая содержит исходный код приложения и его
  тесты:
  - [src/main/java/game](./src/main/java/game) – здесь находится код игры "Ядро Знаний"
      - [game/constants](game/constants) - cодержит текстовые константы для отображения сообщений
      - [game/exceptions](./game/exceptions) - обрабатывает исключения, возноможные во время игры
      - [game/gameplay](./game/gameplay) - основная логика игрового процесса
      - [game/listener](./game/listener) - обработка пользовательского ввода и взаимодействие с данными
      - [game/service](./game/service) - cервисы для управления игровым процессом и логикой взаимодействия
      - [game/ui](./game/ui) - отображения интерфейса игры
      - [game/wordRepo](./game/wordRepo) - репозиторий слов и терминов, используемых в игре
  - [src/test/](./src/test) – здесь находятся тесты для игры
- [mvnw](./mvnw) и [mvnw.cmd](./mvnw.cmd) – скрипты maven wrapper для Unix и
  Windows, которые позволяют запускать команды maven без локальной установки
- [checkstyle.xml](checkstyle.xml),
  [checkstyle-suppression.xml](checkstyle-suppression.xml), [pmd.xml](pmd.xml) и
  [spotbugs-excludes.xml](spotbugs-excludes.xml) – в проекте используются
  [линтеры](https://en.wikipedia.org/wiki/Lint_%28software%29) для контроля
  качества и читабельности кода.
- [.mvn/](./.mvn) – служебная директория maven, содержащая конфигурационные
  параметры сборщика
- [.editorconfig](.editorconfig) – файл с описанием настроек форматирования кода
- [.github/workflows/build.yml](.github/workflows/build.yml) – файл с описанием
  шагов сборки проекта в среде Github
- [.gitattributes](.gitattributes), [.gitignore](.gitignore) – служебные файлы
  для git, с описанием того, как обрабатывать различные файлы, и какие из них
  игнорировать

## Начало работы

Для того чтобы собрать проект, и проверить, что все работает корректно, можно
запустить из модального окна IDEA
[Run Anything](https://www.jetbrains.com/help/idea/running-anything.html)
команду:

```shell
mvn clean verify
```

Для окончания сборки потребуется подождать какое-то время, пока maven скачает
все необходимые зависимости, скомпилирует проект.

Если вы в процессе сборки получили ошибку:

```shell
Rule 0: org.apache.maven.enforcer.rules.version.RequireJavaVersion failed with message:
JDK version must be at least 22
```

Значит, версия вашего JDK ниже 22.

Если получили ошибку:

```shell
Rule 1: org.apache.maven.enforcer.rules.version.RequireMavenVersion failed with message:
Maven version should, at least, be 3.8.8
```

Значит, у вас используется версия maven ниже 3.8.8. Такого не должно произойти,
если вы запускаете сборку из IDEA или через `mvnw`-скрипты.
