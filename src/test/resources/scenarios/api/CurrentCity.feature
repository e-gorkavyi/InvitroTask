Feature: Запрос текущего города

  Scenario Outline: Запрос города, проверка ответа на успех и наличие всех полей
    Given Эндпоинт "https://www.invitro.ru/local/ajax/current-city.php", параметр "CODE" со значениями "<value>"
    Examples:
      | value  |
      | bajmak |
      | moscow |
      | london |