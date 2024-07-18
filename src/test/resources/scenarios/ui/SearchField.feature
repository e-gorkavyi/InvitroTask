Feature: Поиск по сайту
  Scenario: Поиск произвольной строки
    Given Находимся на главной странице "https://invitro.ru/"
    When Вводим в поисковое поле "1515"
    And Нажимаем ENTER