# System Zarządzania Zadaniami
System Zarządzania Zadaniami to aplikacja napisana w języku Java, umożliwiająca użytkownikom zarządzanie zadaniami, organizowanie ich według priorytetów oraz zapisywanie zadań w zewnętrznych plikach w formatach JSON i XML.

## Funkcje
Zarządzanie Zadaniami: Tworzenie, aktualizowanie i usuwanie zadań z danymi takimi jak tytuł, opis, termin wykonania i priorytet.
Filtrowanie Zadań: Filtracja zadań na podstawie statusu ich ukończenia, priorytetu i terminu wykonania.
Sortowanie Zadań: Sortowanie zadań według terminu wykonania.
Raportowanie Zadań: Generowanie raportu podsumowującego liczbę zadań, zadania według priorytetu, ukończone zadania i zaległe zadania.
Trwałość: Zapisywanie i wczytywanie zadań z/do zewnętrznego nośnika w formatach JSON lub XML.
## Struktura Projektu
Pakiet data: Zawiera klasy reprezentujące zadania, priorytety zadań oraz wyjątki niestandardowe.
Pakiet service: Oferuje funkcje do zarządzania zadaniami, przetwarzania zadań (JSON i XML) oraz generowania raportów.
Pakiet main: Zawiera główną klasę do uruchamiania aplikacji.
