Wymagania projektu

Chcemy, żeby tworzenie projektu było dla Ciebie przyjemnością, dlatego samodzielnie wybierzesz temat swojej aplikacji. Wymagamy jednak, aby zostały spełnione wymagania, które opisaliśmy poniżej.
1. Endpointy REST

    Utwórz co najmniej 20 różnych endpointów.
    Co najmniej raz wykorzystaj każdą z poznanych metod HTTP: GET, POST, PUT oraz DELETE.

Jak już wspomnieliśmy, aplikacja powinna zawierać endpointy REST. Nie określamy konkretnie, w jakim celu mają być wykorzystane, ponieważ każdy projekt będzie inny. Samodzielnie zaplanuj przeznaczenie endpointów, zgodnie z przewidywanymi potrzebami przyszłych użytkowników.
2. Pobieranie danych

    Wykorzystaj co najmniej dwa zewnętrzne źródła danych.

Często, tworząc własną aplikację od zera, musimy się mierzyć z brakiem wymaganych informacji. Jak sobie z tym poradzić? Dla przykładu, pisząc system do wirtualnego biura podróży, dane o lotach i hotelach możemy pobrać z API Skyscanner.

W internecie jest bardzo dużo serwisów, które swoje dane udostępniają za darmo. Możesz skorzystać ze stron grupujących wspomniane witryny – na przykład programmable web czy RapidAPI.

Postaraj się znaleźć zastosowanie dla połączenia danych z różnych źródeł. Biorąc przykład wirtualnego biura podróży, możesz np. generować listę lotów w najbliższe dwa weekendy do miejsc, w których prognoza pogody zapowiada słoneczne dni o temperaturze powyżej 30 stopni Celsjusza.
3. Scheduler

    Wymyśl i zaimplementuj co najmniej jedno wykorzystanie schedulera.

Zastosowań schedulera może być wiele. Na wstępie zastanów się, czy w aplikacji znajdą się operacje do wykonania co jakiś określony czas. Może to być np. rozliczanie złożonych zakładów bukmacherskich, pobieranie aktualnej prognozy pogody, czy bieżących kursów walut.
4. Zapis do bazy

    Zaimplementuj co najmniej 10 różnych operacji zapisu danych do bazy.

Korzystanie z bazy danych jest wręcz naturalne w aplikacji backendowej. Pamiętaj, że warto zapisywać nie tylko informacje niezbędne do działania aplikacji, lecz także dane, które z pozoru nie będą dla Ciebie istotne.

Mogą to być na przykład wszystkie działania użytkownika – logowanie, przeglądane informacje, wszystkie operacje zapisu danych do bazy, etc. Wszystko to może mieć znaczenie w przyszłości, zarówno w celu analizy zachowań użytkowników, jak i ewentualnych audytów bezpieczeństwa.
5. Testy

    Stwórz testy pokrywające co najmniej 65% kodu.

Nie możemy zapomnieć o pokryciu naszego kodu testami. Postaraj się przetestować wszystkie możliwe przypadki, jakie mogą wystąpić. Zwróć szczególną uwagę na testy kontrolerów.
6. Wzorce projektowe

    Wykorzystaj co najmniej dwa różne wzorce projektowe.

W trakcie kursu poznaliśmy wiele wzorców projektowych. Nie narzucamy, które wzorce mają być wykorzystane w projekcie, aby nie były stosowane na siłę. Wykorzystaj je tam, gdzie znajdziesz dla nich dobre zastosowanie.

Pamiętaj, że zaplanowanie stosowania wzorca może być trudne. Dlatego przeznacz trochę czasu na przemyślenie tej kwestii i spisanie pomysłów, które przychodzą Ci do głowy.
7. Warstwa widoku

    Wykorzystaj bibliotekę Vaadin do stworzenia warstwy widoku swojej aplikacji.

Nie przejmuj się, że ta biblioteka nie brzmi znajomo – szczegóły jej wykorzystania omówimy w kolejnym module.

Specjalnie nie namawiamy do stosowania stosowania Angulara czy Reacta, ponieważ są dosyć rozległe frameworki. Ważne jest, aby Twoja aplikacja miała działającą warstwę wizualną, której stworzenie nie zajmie Ci większości czasu poświęconego na ten projekt. Dlatego Vaadin świetnie się nadaje do tego celu, mimo swoich ograniczeń. Jest to biblioteka dość prosta w zastosowaniu dla osób, które programują w Javie.