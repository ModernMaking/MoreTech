# MoreTech

 ##  Наше решение работает как сайт
 
 Ссылка: http://vds104.server-1.biz:8090/

Пользователь, у которого есть монеты:

Логин: Я

пароль: Я
 
 ## Инструкция по установке и запуску
 
1) Установить на сервер Java 11, Maven и  MySQL 8
2)  Запустить сервер MySQL 8 и создать базу данных с названием vtb
3) Склонировать репозиторий
```rb
git clone https://github.com/ModernMaking/MoreTech
```
Переключиться на ветку master
```rb
git checkout master
```

4) Перейти в папку проекта
```rb
cd MoreTech
```

При необходимости изменить логин и пароль от базы данных в файле application.properties

![image](https://user-images.githubusercontent.com/46486489/194738869-73ecb2d2-a7b9-4067-a758-8f74bae1b116.png)


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


## Стек разработки

Приложение разработано с помощью фреймворка Java Spring Boot

## Структура проекта

![image](https://user-images.githubusercontent.com/46486489/194738768-c050900b-e75b-48b0-ac93-2ffe4f9c9589.png)
![image](https://user-images.githubusercontent.com/46486489/194738893-a2fcd15f-e160-44c3-b8ca-625d9ccddf9e.png)
![image](https://user-images.githubusercontent.com/46486489/194738903-abb04b8a-9121-4e20-86dc-9adb55afbb9c.png)
![image](https://user-images.githubusercontent.com/46486489/194738910-2b0d0ac4-e896-4068-96d6-2b9cbed8f962.png)

controller - пакет контроллеров URL,  отвечающих за API

model - Классы сущностей базы данных 

repo - Репозитории сущностей базы данных. Имеются на каждый класс из model

/resources/templates - шаблоны  HTML-страниц

application.properties - свойства приложения (логин/пароль от базы данных и т.д.)

## Примеры кода

Контроллер на URL http://localhost:8090/user/

![image](https://user-images.githubusercontent.com/46486489/194739037-a3bf6fc6-bfa1-4f43-94fe-3e175e56f82d.png)


 API-метод регистрации http://localhost:8090/user/add
 
 ![image](https://user-images.githubusercontent.com/46486489/194739045-f7e2a6f3-0a88-4f4e-a4dd-4d923eb9e13a.png)


Генерация html-страницы по шаблону (шаблон в файле register1.html в папке templates)

![image](https://user-images.githubusercontent.com/46486489/194739066-3d458529-add6-44ed-96ee-30cc21a463c7.png)

