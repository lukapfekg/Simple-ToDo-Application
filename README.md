# Simple-ToDo-Application

Uputstvo za postavljanje aplikacije:
1. Prvo je potrebno otvoriti MySQL i pokrenuti lokalni server.
2. Pokrece se program. Prvim pokretanjem aplikacije se generise tabela u bazi podataka.
3. Potrebno je ugasiti program.
4. Unutar klase src/java/db/HibernateUtil potrebno je zakomentarisati 48. liniju, i skinuti komentar sa 49. linije.
5. Program se zatim pokrece, i na ekranu ce se pojaviti GUI aplikacija.

Uputstvo za korišćenje aplikacije:
Na početku će baza podataka biti prazna, i samim tim i prozor aplikacije. Potrebno je dodati novi <i>task</i> pritiskom na dugme <i>ADD TASK</i>.
Pritiskom na to dugme otvorice se novi prozor koji sadrzi polje u kojem se upisuje tekst taska i dugme kojim se on unosi u program.
Nakon dodavanja taska on ce se prikazati na ekranu. Sa njegove leve strane se nalazi prazan krug. Klikom misa na dati krug task ce se oznaciti kao odradjen i krug ce pozeleneti.
U donjem levom uglu aplikacije se nalazi i dugme <i>SELECT</i>. Pritiskom na dugme je moguce selektovati odredjene taskove. Selektovanje taskova se vrsi pritiskom na krug sa leve strane taska.
Nakon selektovanja, selektovane taskove je moguce obrisati pritiskom na dugme <i>DELETE</i> koje ce se prikazati pored dugmeta <i>SELECT</i>.
