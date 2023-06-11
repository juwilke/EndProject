Kraków, data 11.06.2023r.

**STUDIA PODYPLOMOWE
– TESTER AUTOMATYZUJĄCY W SELENIUM**

PROJEKT: AUTOMATYZACJA TESTÓW APLIKACJI WEBOWEJ W JAVA Z WYKORZYSTANIEM BIBLIOTEKI WEBDRIVER

![img.png](img.png)

Adres strony internetowej testowanego projektu: https://automationpractice.pl/index.php/

[ ] Zastosowanie Data Driven Testing

[X] Zastosowanie wzorca Page Object Pattern

[X] Zastosowanie podejścia Page Factory


Autor: Justyna Wilke

Ocena: ………

---
**1. Opis projektu**

Celem projektu jest przetestowanie podstawowych funkcjonalności strony internetowej sklepu z odzieżą:

- TC 1: Wysłanie formularza kontaktowego
- TC 2: Stworzenie nowego konta użytkownika
- TC 3: Zalogowanie użytkownika
- TC 4: Wyszukanie wybranego produktu
- TC 5: Sortowanie produktów po cenie

W niniejszej pracy zastosowano wzorzec projektowy Page Object oraz podejście Page Factory.

**2. Przypadki testowe**

TC 1: Wysłanie formularza kontaktowego

| ID     | Tytuł przypadku testowego  | Kroki testowe                                                              | Oczekiwane zachowanie                                                          |
|--------|----------------------------|----------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| TC 1.1 |wysłanie pustego formularza<br/>shouldNotAllowToSendEmptyForm | - wejdź na stronę główną <br/>- kliknij “Contact us”<br/> - kliknij “Send” | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany       |
| TC 1.2 |wysłanie formularza bez adresu e-mail<br/>shouldNotAllowToSendFormWithoutEmail| - wejdź na stronę główną<br/>- kliknij “Contact us”<br/>- wybierz temat<br/>- wpisz nr zamówienia<br/>- wpisz wiadomość<br/>- kliknij “Send” | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany       |
| TC 1.3 |wysłanie formularza bez tematu<br/>shouldNotAllowToSendFormWithout-Subject| - wejdź na stronę główną<br/>- kliknij “Contact us”<br/>- wpisz adres e-mail<br/>- wpisz nr zamówienia<br/>- wpisz wiadomość<br/>- kliknij “Send” | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany       |
| TC 1.4 |wysłanie formularza bez wiadomości<br/>shouldNotAllowToSendFormWithout-Message| - wejdź na stronę główną<br/>- kliknij “Contact us”<br/>- wybierz temat<br/>- wpisz adres e-mail<br/>- wpisz nr zamówienia<br/>- kliknij “Send” | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany       |
| TC 1.5 |wysłanie formularza z poprawnymi danymi<br/>canSendValidForm | - wejdź na stronę główną<br/>- kliknij “Contact us”<br/>- wybierz temat<br/>- wpisz adres e-mail<br/>- wpisz nr zamówienia<br/>- wpisz wiadomość<br/>- kliknij “Send” | - wyświetlenie informacji o wysłaniu formularza<br/>- formularz został wysłany |


TC 2: Stworzenie nowego konta użytkownika

| ID     | Tytuł przypadku testowego                                        | Kroki testowe                                                                                                                                                                               | Oczekiwane zachowanie                                                                                                                                                        |
|--------|------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TC 2.1 | wysłanie pustego formularza<br/>shouldNotAllowCreateAccountWithInvalidEmail | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- kliknij "Create an account"                                                                                                          | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany                                                                                                     |
| TC 2.2 | wysłanie formularza z poprawnymi danymi<br/>canCreateNewAccount  | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- kliknij "Create an account"                                                                                 | - formularz zostanie wysłany<br/>- przejście na stronę z formularzem "Your Personal Information"<br/>- w polu "Email" zostanie wpisany adres e-mail podany przez użytkownika |
| TC 2.3 | wysłanie formularza tylko z adresem e-mail<br/>shouldNotAllowToCreateAccountWithEmailOnly | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- kliknij "Create an account"<br/>- kliknij "Register"                                                                                 | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany                                                                                                     |
| TC 2.4 | wysłanie formularza bez imienia<br/>shouldNotAllowToCreateAccountWithoutFirstName | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- kliknij "Create an account"<br/>- wybierz tytuł<br/>- wpisz nazwisko<br/>- wpisz hasło<br/>- kliknij "Register" | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany                                                                                                     |
| TC 2.5 | wysłanie formularza bez nazwiska<br/>shouldNotAllowToCreateAccountWithoutLastName | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- kliknij "Create an account"<br/>- wybierz tytuł<br/>- wpisz imię<br/>- wpisz hasło<br/>- kliknij "Register" | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany                                                                                                     |
| TC 2.6 | wysłanie formularza bez hasła<br/>shouldNotAllowToCreateAccountWithoutPassword | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- kliknij "Create an account"<br/>- wybierz tytuł<br/>- wpisz imię<br/>- wpisz nazwisko<br/>- kliknij "Register" | - wyświetlenie informacji o błędzie<br/>- formularz nie zostanie wysłany                                                                                                     |
| TC 2.7 | wysłanie formularza z poprawnymi danymi<br/>canCreateNewAccount  | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- kliknij "Create an account"<br/>- wybierz tytuł<br/>- wpisz imię<br/>- wpisz nazwisko<br/>- wpisz hasło<br/>- kliknij "Register" | - wysłanie formularza<br/>- informacja o stworzeniu konta<br/>- przeniesienie na stronę "My account"                                                                          |

TC 3: Zalogowanie użytkownika

| ID     | Tytuł przypadku testowego                                                                  | Kroki testowe                                                                                                              | Oczekiwane zachowanie                                          |
|--------|:-------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| TC 3.1 | wysłanie formularza bez hasła<br/>shouldNotAllowLoginWithoutPassword                       | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- kliknij "Sign in"                          | - wyświetlenie informacji o błędzie<br/>- użytkownik nie zostanie zalogowany |
| TC 3.2 | wysłanie formularza z niepoprawnym hasłem<br/>shouldNotAllowLoginWithIncorrectPassword     | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- wpisz błędne hasło<br/>- kliknij "Sign in" | - wyświetlenie informacji o błędzie<br/>- użytkownik nie zostanie zalogowany |
| TC 3.3 | wysłanie formularza z niepoprawnym adresem e-mail<br/>shouldNotAllowLoginWithInvalidEmail  | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz błędny adres e-mail<br/>- wpisz hasło<br/>- kliknij "Sign in" | - wyświetlenie informacji o błędzie<br/>- użytkownik nie zostanie zalogowany |
| TC 3.4 | wysłanie formularza z poprawnymi danymi<br/>canLoginWithCorrectData                        | - wejdź na stronę główną<br/>- kliknij "Sign in"<br/>- wpisz adres e-mail<br/>- wpisz hasło<br/>- kliknij "Sign in"        | - zalogowanie użytkownika<br/>- przeniesienie na stronę "My account"                                   |

TC 4: Wyszukanie wybranego produktu

| ID     | Tytuł przypadku testowego               | Kroki testowe                                                            | Oczekiwane zachowanie                                                                                                            |
|--------|-----------------------------------------|--------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| TC 4.1 | wysłanie pustego formularza<br/>shouldNotAllowSearchWithEmptyField | - wejdź na stronę główną<br/> - kliknij lupę                             | - formularz zostanie wysłany<br/> - przejście na stronę "Search"<br/>- wyświetlenie ostrzeżenia: "Please enter a search keyword" |
| TC 4.2 | wysłanie formularza z poprawnymi danymi<br/>shouldSeeSearchResults | - wejdź na stronę główną<br/> - wpisz nazwę produktu<br/> - kliknij lupę | - formularz zostanie wysłany<br/> - przejście na stronę "Search"<br/>- wyświetlenie rezultatu wyszukiwania                       |

TC 5: Sortowanie produktów po cenie

| ID     | Tytuł przypadku testowego                                                 | Kroki testowe                                                                                | Oczekiwane zachowanie                       |
|--------|---------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|---------------------------------------------|
| TC 5.1 | stortowanie produktów - cena rosnąco<br/>canSortItemsByPriceLowestFirst   | - wejdź na stronę główną<br/> - kliknij "Dresses"<br/> - wybierz Sort by "Price Lowest First" | - wyświetlenie posortowanej listy produktów<br/>cena rosnąco |
| TC 5.2 | stortowanie produktów - cena malejąco<br/>canSortItemsByPriceHighestFirst | - wejdź na stronę główną<br/> - kliknij "Dresses"<br/> - wybierz Sort by "Price Highest First"| - wyświetlenie posortowanej listy produktów<br/>cena malejąco |

