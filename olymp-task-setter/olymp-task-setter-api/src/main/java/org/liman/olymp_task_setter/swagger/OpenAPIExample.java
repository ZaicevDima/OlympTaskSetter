package org.liman.olymp_task_setter.swagger;


public class OpenAPIExample {

    public static final String REGISTRATION_OLYMPIAD = """
            {
              "name": "Олимпиада ЮМШ",
              "year": 2025
            }
            """;

    public static final String REGISTRATION_ADMIN = """
            {
              "role": "admin",
              "name": "Дмитрий",
              "surname": "Зайцев",
              "patronymic": "Игоревич"
            }
            """;

    public static final String REGISTRATION_ACCEPTOR = """
            {
              "role": "acceptor",
              "name": "Александр",
              "surname": "Зачиняев",
              "patronymic": "Васильевич"
            }
            """;

    public static final String REGISTRATION_STUDENT = """
            {
              "role": "student",
              "name": "Иван",
              "surname": "Иванов",
              "patronymic": "Иванович",
              "classNumber": "9",
              "school": "ЮМШ"
            }
            """;
}
