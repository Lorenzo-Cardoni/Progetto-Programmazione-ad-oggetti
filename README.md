## Progetto OPENWEATHER - Città, pressione 
Il progetto permette all'utente di visualizzare la pressione di una certa città e le statistiche di un determinato periodo.

## UML
In fase di progettazione sono stati disegnati i seguenti diagrammi UML. Durante la realizzazione del progetto sono state eseguite varie modifiche a seconda delle esigenze. Le modifiche effettuate sono riportate sotto al proprio diagramma UML.

# Use case diagram
!(./images/UseCase1.jpg)
* l'utente si interfaccia al programma attraverso una GUI, a seconda dell'operazione scelta si esegue una certa richiesta. 
  Show Stats applica un filtro ai dati nel database, che vengono parsati da un'apposita classe. Succesivamente si creano le statistiche che vengono mostrate all'utente.
  I dati presenti nel database sono ottenuti, in formato JSON, da delle chiamate API.
  
# Class diagram
!(./images/ClassDiagram.jpg)
* Model: package contenente il formato dei dati.
* GUI: package con classi che implementano la GUI con cui l'utente interagirà.
* Service: package che si interfaccia all'API Openwheter, ottenendo i dati e parsandoli a seconda della necessità.
* Filters: package contenente una interfaccia per le classi filterPressureStandard e filterPressureCustomized. Le classi prenderanno in input un periodo, una città e i dati presenti nel database e in output un vettore contenente le pressioni filtrate. Il fitro standard avrà un periodo predefinito dal programmatore (un giorno, una settimana ed un mese), mentre il filtro personalizzato filtrerà i dati a seconda di un periodo deciso dall'utente.
*Statistics: package contenente la classe Stats che prende in input un vettore di pressioni e ne genera le relative statistice.

Nota: Nell'UML non sono presenti i seguenti package
* DataBase: package che permette di gestire i dati in un file .txt
* Utils: package contenente delle classi che sono richiamate in altri classi.

# Sequence diagram
!(./images/SequenceDiagram.jpg)
La GUI richiamail metodo getpressure della classe APIController che effettuerà un richiesta all'API di OpenWeather ottenedo in risposta i dati in formato JSON. I dati saranno parsati dalla classe JsonParse e scritti nel dataBase. La pressione ricevuta e parsata sarà visualizzata dalla GUI.

La GUI richiama con il metodo getStats della classe Filter che leggerà i dati presenti nel dataBase attraverso il metodo readData. I dati saranno ritornati come un vettore di pressioni costruito dalla classe BuildinVectorPressure. Successivamente con i dati ottenuti si creano le statistiche richiamando il metodo createStats della classe Stats. Una volta ottenute le statistiche veranno visualizzate dalla GUI. 

Nota: durente la scrittura del codice sono stati cambiati i nomi di alcuni metodi/classi, ma le loro funzionalità sono rimaste invariate.


