# University Console App 🎓

Простий Spring Boot консольний застосунок для управління університетом.  
Реалізовано базові команди для роботи з департаментами та лекторами.

## ⚙️ Технології
- Java 17
- Spring Boot 
- Spring Data JPA
- PostgreSQL
- Liquibase
- Maven

## 🚀 Налаштування проєкту
1. Клонувати репозиторій:
   ```bash
   git clone https://github.com/your-username/university-console-app.git
   cd university-console-app

## Створити файл .env у корені проєкту з параметрами БД:

    DB_HOST=localhost
    DB_PORT=5432
    DB_NAME=university_console_app
    DB_USERNAME=postgres
    DB_PASSWORD=your_password

## Запустити застосунок:
    mvn clean package
    java -jar target/university-console-app-0.0.1-SNAPSHOT.jar


## 📚 Основні команди
Who is head of department {department_name} – завідувач кафедри

Show {department_name} statistics – статистика за ступенями

Show the average salary for the department {department_name} – середня зарплата

Show count of employee for {department_name} – кількість працівників

Global search by {template} – пошук викладачів по імені/прізвищу

## 🛠️ Міграції

Структура БД та дані керуються через Liquibase (db/changelog/)

Початкові дані збережені у CSV-файлах у db/seeds/