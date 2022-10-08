# MoreTech

 ##  Наше решение работает как сайт
 
 Ссылка: http://vds104.server-1.biz:8090/
 
 ## Инструкция по установке и запуску
 
1) Установить на сервер Java 11, Maven и  MySQL 8
2)  Запустить сервер MySQL 8 и создать базу данных с названием vtb
3) Склонировать репозиторий
```rb
git clone https://github.com/ModernMaking/MoreTech
```
4) Перейти в папку проекта
```rb
cd MoreTech
```
5)  Скомпилировать проект
```rb
mvn install
```
6) Запустить исполняемый файл
```rb
cd target
```

```rb
java -jar vtb2-0.0.1-SNAPSHOT.jar
```
7) Запустить сайт в бразуере:
```rb
http://localhost:8090
```
