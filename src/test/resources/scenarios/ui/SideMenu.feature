Feature: Проверка работоспособности бокового меню

  Scenario: Сделать клик на каждом пункте бокового меню раздела "Медицинские услуги", вложенные пункты

    Given Переходим в раздел мед. услуг "https://www.invitro.ru/radiology/"
    When Делаем клик на всех пунктах и подпунктах бокового меню