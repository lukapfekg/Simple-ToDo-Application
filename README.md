# Simple-ToDo-Application

####Uputstvo za postavljanje aplikacije:
1. Prvo je potrebno otvoriti MySQL i pokrenuti lokalni server.
2. Pokreće se program. Prvim pokretanjem aplikacije generiše se tabela u bazi podataka.
3. Potrebno je ugasiti program.
4. Unutar klase src/java/db/HibernateUtil potrebno je zakomentarisati 48. liniju, i skinuti komentar sa 49. linije.
5. Program se zatim pokreće, i na ekranu će se pojaviti GUI aplikacija.

####Uputstvo za korišćenje aplikacije:  
Na početku će baza podataka biti prazna, i samim tim i prozor aplikacije. Potrebno je dodati novi <i>task</i> pritiskom na dugme <i>ADD TASK</i>.
Pritiskom na to dugme otvoriće se novi prozor koji sadrži polje u kojem se upisuje tekst taska i dugme kojim se on unosi u program.
Nakon dodavanja taska on će se prikazati na ekranu. Sa njegove leve strane se nalazi prazan krug. Klikom kursora na dati krug task će se označiti kao odrađen i krug će pozeleneti.
U donjem levom uglu aplikacije se nalazi i dugme <i>SELECT</i>. Pritiskom na dugme je moguće selektovati određene taskove. Selektovanje taskova se vrši pritiskom na krug sa leve strane taska.
Nakon selektovanja, selektovane taskove je moguće obrisati pritiskom na dugme <i>DELETE</i> koje će se prikazati pored dugmeta <i>SELECT</i>.
Takođe pritiskom na dugme <i>DESELECT</i> moguće je deselektovati sve taskove.
