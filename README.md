## Progetto OPENWEATHER - Città, pressione 
Il progetto permette all'utente di visualizzare la pressione di una certa città e le statistiche di un determinato periodo.

## Come usare l'applicazione
1. Scaricare codice sorgente
2. Aprire il progetto tramite un IDE
3. Aprire la cartella src del progetto
4. Fare il run della classe main

![](./images/img1.jpg)

* Una volta avviato comparira' la seguente schermata che chiedera' all'utente di inserire un nome di una citta' (come ad esempio Agugliano o Pesaro). Se la citta' non esiste comparira' un messaggio di errore.

![](./images/img2.jpg)

* Verra' chiesto all'utente se vuole visualizzare la pressione attuale o le statistiche di un determinato periodo.

![](./images/img3.jpg)

* La pressione attuale verra' mostrata con una finestra

![](./images/img4.jpg)

* Per visualizzare le statistiche di un periodo, si possono scegliere tra 3 periodi già preimpostati (giornaliero, settimanale e mensile) oppure un periodo personalizzato dall'utente.

![](./images/img5.jpg)

* Schermata statistiche

![](./images/img6.jpg)

* Per scegliere un periodo personalizzato ci sara' una apposita finestra dove inserire la data iniziale e la data finale. Se non si inseriscono le date, l'applicazione fara' comparire un messaggio di errore. Le date dovranno essere inserite nel formato "aaaa-mm-dd" e se verrano inserite in un formato errato l'utente sara' allertato da un messaggio.
L'ordine delle due date e' irrilevante, in quanto sara' il programma ad occuparsi di quale data viene prima o dopo.

![](./images/img7.jpg)

* Per chiudere il programma chiudere tutte le finestre.

## UML
In fase di progettazione sono stati disegnati i seguenti diagrammi UML. Durante la realizzazione del progetto sono state eseguite varie modifiche a seconda delle esigenze. Le modifiche effettuate sono riportate sotto al proprio diagramma UML.

# Use case diagram

![](./images/UsaCase1.jpg)
* l'utente si interfaccia al programma attraverso una GUI, a seconda dell'operazione scelta si esegue una certa richiesta. 
  Show Stats applica un filtro ai dati nel database, che vengono parsati da un'apposita classe. Succesivamente si creano le statistiche che vengono mostrate all'utente.
  I dati presenti nel database sono ottenuti, in formato JSON, da delle chiamate API.
  
# Class diagram

![](./images/ClassDiagram.jpg)
* Model: package contenente il formato dei dati.
* GUI: package con classi che implementano la GUI con cui l'utente interagirà.
* Service: package che si interfaccia all'API Openwheter, ottenendo i dati e parsandoli a seconda della necessità.
* Filters: package contenente una interfaccia per le classi filterPressureStandard e filterPressureCustomized. Le classi prenderanno in input un periodo, una città e i dati presenti nel database e in output un vettore contenente le pressioni filtrate. Il fitro standard avrà un periodo predefinito dal programmatore (un giorno, una settimana ed un mese), mentre il filtro personalizzato filtrerà i dati a seconda di un periodo deciso dall'utente.
*Statistics: package contenente la classe Stats che prende in input un vettore di pressioni e ne genera le relative statistice.

Nota: Nell'UML non sono presenti i seguenti package
* DataBase: package che permette di gestire i dati in un file .txt
* Utils: package contenente delle classi che sono richiamate in altri classi.

# Sequence diagram

![](./images/SequenceDiagram.jpg)
La GUI richiamail metodo getpressure della classe APIController che effettuerà un richiesta all'API di OpenWeather ottenedo in risposta i dati in formato JSON. I dati saranno parsati dalla classe JsonParse e scritti nel dataBase. La pressione ricevuta e parsata sarà visualizzata dalla GUI.

La GUI richiama con il metodo getStats della classe Filter che leggerà i dati presenti nel dataBase attraverso il metodo readData. I dati saranno ritornati come un vettore di pressioni costruito dalla classe BuildinVectorPressure. Successivamente con i dati ottenuti si creano le statistiche richiamando il metodo createStats della classe Stats. Una volta ottenute le statistiche veranno visualizzate dalla GUI. 

Nota: durente la scrittura del codice sono stati cambiati i nomi di alcuni metodi/classi, ma le loro funzionalità sono rimaste invariate.

## Autori

| Autori         | Email | Contributo |
|----------------|-------|------------|
| Lorenzo Cardoni| S1094392@studenti.univpm.it| 50% |
| Franco Zagorschi | francozagorschi@gmail.com | 50% |

