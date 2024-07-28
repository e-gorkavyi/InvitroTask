Feature: Запрос текущего города

  Scenario Outline: Запрос города, проверка ответа на успех и наличие всех полей
    Given Эндпоинт "https://www.invitro.ru/local/ajax/current-city.php", параметр "CODE" со значениями "<value>", ключи "<key1>" "<key2>" "<key3>" равны null
    Examples:
      | value  | key1 | key2 | key3  |
      | bajmak | city | code | guide |
      | moscow | city | code | guide |
      | london | city | code | guide |