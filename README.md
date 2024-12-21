# MITIA_Labs

Небольшой проект по дисциплине "Управление информационно-технологической инфраструктурой и архитектурой".

В качестве приложения для реализации была выбрана простейшая панель для взаимодействия с сущностью пользователя.

Для запуска приложения необходимо задать следующие переменные окружения:

* DB_CONN_STRING (в формате jdbc: итд)
* DB_USER
* DB_PASS

При необходимости, измените схему в файле application.yml с public на нужную.

Swagger для тестирования API находится по адресу: 
http://localhost:8080/swagger-ui/index.html

Запуск ansible playbook:
sudo ansible-playbook -i ~/inventory.ini /mnt/c/Users/user/IdeaProjects/mitia/spring-app-playbook.yml