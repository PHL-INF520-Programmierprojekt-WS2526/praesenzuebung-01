# Präsenzübung 1
[Link to English version](./README_en.md)

In dieser Übung wiederholen Sie die bisher gelernten Konzepte zur Struktur von Java-Programmen.

## Übung 1: Ein einfaches Java-Programm implementieren [20 Punkte]

Um die Java-Syntax zu wiederholen, werden Sie ein einfaches Java-Programm implementieren, um die Arbeitsstunden nach dem Europäischen System zur Übertragung und Akkumulierung von Studienleistungen (Englisch European Credit Transfer and Accumulation System, **ECTS**) für verschiedene Kurse zu berechnen.

Ein ECTS-Punkt entspricht in der Regel 25 bis 30 Arbeitsstunden.

### Aufgaben

1. Implementieren Sie eine neue Java-Klasse mit dem Namen `ECTSCalculator` im Paket [`de.phl.programmingproject.ects`](src/main/java/de/phl/programmingproject/ects).
2. Deklarieren Sie eine `public static void main` Methode. (3 Punkte)
3. Deklarieren Sie eine lokale Variable vom Typ `int` mit dem Namen `ectsPoints` und initialisieren Sie sie mit dem Wert `6`.  (3 Punkte)
4. Deklarieren Sie eine lokale Variable vom Typ `int` mit dem Namen `hoursPerEcts` und initialisieren Sie diese mit dem Wert `30`. (3 Punkte)
5. Berechnen Sie die Gesamtarbeitsstunden, indem Sie `ectsPoints` mit `hoursPerEcts` multiplizieren und das Ergebnis einer Variable vom Typ `int` mit dem Namen `totalHours` zuweisen. (4 Punkte)
6. Geben Sie die berechneten Gesamtstunden (`totalHours`) in der Konsole mit `System.out.println` aus. Die Ausgabe muss entweder `total hours:` oder `Gesamstunden:` gefolgt von der Anzahl der Gesamtstunden enthalten. (4 Punkte)

## Übung 2: Objekte erzeugen und verwenden [30 Punkte]

Ihnen wurde ein Programm zur Verfügung gestellt, das Waschbären im Wald modelliert. Der Quellcode ist im Paket [`de.phl.programmingproject.raccoon`](src/main/java/de/phl/programmingproject/raccoon) verfügbar.

### Quellcode-Beschreibung

Das Paket enthält die Klasse `Raccoon`, `Food` und `Forest`:

#### [`Raccoon`](src/main/java/de/phl/programmingproject/raccoon/Raccoon.java) Klasse
Die [`Raccoon`](src/main/java/de/phl/programmingproject/raccoon/Raccoon.java) Klasse repräsentiert einen Waschbären mit den Attributen Name (`name`), Fellfarbe (`furColor`) und Gewicht in Gramm (`weight`). Sie besitzt die folgenden Methoden zum Fressen von Nahrung und zum Anzeigen von Informationen über den Waschbären:
- `Raccoon(final String name, final String furColor, final int weight)`: Ein Konstruktor, um ein neues Raccoon-Objekt mit dem gegebenen Namen, Fellfarbe und Gewicht zu erstellen.
- `void eat(final Food food)`: Erhöht das Gewicht des Waschbären basierend auf den Gewicht der Nahrung.
- `String getInfo()`: Gibt einen String mit dem Namen, der Fellfarbe und dem Gewicht des Waschbären zurück.

#### [`Food`](src/main/java/de/phl/programmingproject/raccoon/Food.java)  Klasse
Die [`Food`](src/main/java/de/phl/programmingproject/raccoon/Food.java) Klasse repräsentiert Nahrung für Waschbären mit den Attributen Name (`name`) und Gewicht in Gramm (`weight`). Sie besitzt die folgenden Methoden:
- `Food(final String name, final int weight)`: Ein Konstruktor, um ein neues Food-Objekt mit dem gegebenen Namen und Gewicht zu erstellen.
- `String getInfo()`: Gibt einen String mit dem Namen und dem Gewicht der Nahrung zurück.

#### [`Forest`](src/main/java/de/phl/programmingproject/raccoon/Forest.java) Klasse
Die [`Forest`](src/main/java/de/phl/programmingproject/raccoon/Forest.java) Klasse repräsentiert einen Wald, der eine Sammlung von Waschbären enthält (`raccoons`). Sie besitzt die folgenden Methoden:
- `Forest(final String name, final int capacity)`: Ein Konstruktor, um ein neues Forest-Objekt mit dem gegebenen Namen und der Kapazität zu erstellen.
-  `List<Raccoon> getRaccoons()`: Gibt eine Liste aller Waschbären im Wald zurück.
- `void addRaccoon(final Raccoon raccoon)`: Fügt einen Waschbären zum Wald hinzu, wenn die Kapazität nicht überschritten wird.
- `String getInfo()`: Gibt einen String mit dem Namen und Kapazität des Waldes und der Anzahl der Waschbären zurück.

### Aufgaben

Implementiert die folgenden Aufgaben in der `main`-Methode, die sich in der [`RaccoonForestApp`](src/main/java/de/phl/programmingproject/raccoon/RaccoonForestApp.java) Klasse im Paket [`de.phl.programmingproject.raccoon`](src/main/java/de/phl/programmingproject/raccoon/) befindet.

1. Erzeuge ein neues `Forest` Objekt mit dem Namen "Black Forest" und einer Kapazität von 3 Waschbären. (2 Punkte)
2. Erzeuge folgende zwei Waschbären (`Raccoon` Objekte) und gib ihre Informationen mit der `getInfo()`-Methode in der Konsole aus: (6 Punkte)
   * Name: "Bandit", Fellfarbe: "Gray", Gewicht: 5.000 Gramm
   * Name: "Shadow", Fellfarbe: "Obsidian", Gewicht: 4.800 Gramm
3. Füge die beiden Waschbären zum Wald hinzu. (4 Punkte)
4. Erzeuge folgende zwei Nahrungsmittel (`Food` Objekte): (6 Punkte)
   * Name: "Berries", Gewicht: 300 Gramm
   * Name: "Fish", Gewicht: 700 Gramm
5. Lass den Waschbären "Bandit" die Beeren (*Berries*) und "Shadow" den Fisch (*Fish*) fressen, indem du die `eat(final Food food)`-Methode verwendest. Gib anschließend wieder die Informationen der Waschbären über die Konsole aus (6 Punkte)
6. Berechne die Gewichtszunahme von "Bandit" und "Shadow", indem du ihr Gewicht vor und nach dem Fressen vergleichst. Gib die Gewichtszunahme in der Konsole wie folgt aus: 
   * "Gewichtszunahme Bandit: XYZ Gramm"
   * "Gewichtszunahme Shadow: XYZ Gramm" 
   
    **WICHTIG**: Nutze für den Namen die `getName()`-Methode der Waschbären und für das zugenommene Gewicht die berechnete Differenz.
   (8 Punkte)

## Übung 3: Kontrollflussstrukturen in Dungeons & Dragons [50 Punkte]
In dieser Übung wiederholen Sie die Kontrollflussstrukturen in Java, einschließlich bedingter Anweisungen, `switch-case` und Schleifen.

Dafür verwenden wir ein einfaches Dungeons & Dragons (D&D) Spielmodell. Der Quellcode ist im Paket [`de.phl.programmingproject.dnd`](src/main/java/de/phl/programmingproject/dnd) verfügbar.

### Quellcode-Beschreibung

Das Paket enthält die Klassen `Player`, `Monster` und `DungeonsAndDragons` und die zwei Enums `CharacterClass` und `Status`.

#### [`Player`](src/main/java/de/phl/programmingproject/dnd/Player.java) Klasse
Die [`Player`](src/main/java/de/phl/programmingproject/dnd/Player.java) Klasse repräsentiert einen Charakter im D&D-Spiel mit den Attributen Name (`name`), Klasse (`characterClass`), Lebenspunkte (`hitPoints`) und Status (`status`. Sie besitzt die folgenden Methoden für den Kampf mit Monstern:
* `Player(final String name, final CharacterClass characterClass, int hitPoints)`: Ein Konstruktor, um ein neues Player-Objekt mit dem gegebenen Namen, Klasse und Lebenspunkten zu erstellen.
* `String attack(final Monster monster)`: Um einen Angriff gegen ein Monster durchzuführen. Dabei werden die Lebenspunkte des Monsters reduziert und die Beschreibung des Angriffs als String zurückgegeben.
* `void takeDamage(final int damage)`: Reduziert die Lebenspunkte des Charakters um den angegebenen Schaden und aktualisiert den Status entsprechend.

##### [`Monster`](src/main/java/de/phl/programmingproject/dnd/Monster.java) Klasse
Die [`Monster`](src/main/java/de/phl/programmingproject/dnd/Monster.java) Klasse repräsentiert ein Monster im D&D-Spiel mit den Attributen Name (`name`), Lebenspunkte (`hitPoints`), Stärke (`strength`) und Status (`status`). Sie besitzt die folgenden Methoden:
* `Monster(final String name, final int hitPoints, final int strength)`: Ein Konstruktor, um ein neues Monster-Objekt mit dem gegebenen Namen, Lebenspunkten und Stärke zu erstellen.
* `String attack(final Player player)`: Um einen Angriff gegen einen Charakter durchzuführen. Dabei werden die Lebenspunkte des Charakters reduziert.
* `void takeDamage(final int damage)`: Reduziert die Lebenspunkte des Monsters um den angegebenen Schaden und aktualisiert den Status entsprechend.

#### [`DungeonsAndDragons`](src/main/java/de/phl/programmingproject/dnd/DungeonsAndDragons.java) Klasse
Die [`DungeonsAndDragons`](src/main/java/de/phl/programmingproject/dnd/DungeonsAndDragons.java) Klasse enthält die `main`-Methode zum Starten des Spiels und die `fight`-Methode zur Simulation eines Kampfes zwischen einem Charakter und einem Monster:
* `public static void main(final String[] args)`: Die Hauptmethode zum Starten des Spiels.
* `public void fight(final Player player, final Monster monster)`: Simuliert einen Kampf zwischen einem Charakter und einem Monster.
* `public List<Monster> createMonsters()`: Erstellt eine Liste von Monstern mit unterschiedlichen Attributen.

### Aufgaben 
Implementieren Sie die folgenden Aufgaben in der `main`-Methode der [`DungeonsAndDragons`](src/main/java/de/phl/programmingproject/dnd/DungeonsAndDragons.java)-Klasse sowie in den [`Player`](src/main/java/de/phl/programmingproject/dnd/Player.java)- und [`Monster`](src/main/java/de/phl/programmingproject/dnd/Monster.java)-Klassen im Paket [`de.phl.programmingproject.dnd`](src/main/java/de/phl/programmingproject/dnd/):

1. Implementieren Sie in der `attack(final Monster monster)`-Methode der [`Player`](src/main/java/de/phl/programmingproject/dnd/Player.java)-Klasse eine `switch-case`-Struktur, die den Schaden basierend auf der Klasse des Charakters berechnet und dem Monster hinzufügt.
   * Der Schaden für jede Klasse ist wie folgt:
       
       | CharacterClass | Schaden |
         |---|---|
         | `WARRIOR` | 15 |
         | `MAGE` | 20 |
         | `PALADIN` | 10 |
          
   * Um den Schaden hinzuzufügen, rufen Sie die `takeDamage(final int damage)`-Methode des Monsters auf.

   * Geben Sie die Beschreibung des Angriffs als String zurück: 
      
     | CharacterClass | Angriffsbeschreibung |
     |---|---|
     | `WARRIOR` | Schwertstreich |
     | `MAGE` | Feuerball |
     | `PALADIN` | Gerechte Rache |
     (20 Punkte)t
2. Implementieren Sie die `takeDamage(final int damage)`-Methode der [`Player`](src/main/java/de/phl/programmingproject/dnd/Player.java)- und [`Monster`](src/main/java/de/phl/programmingproject/dnd/Monster.java)-Klasse mit einer bedingten Anweisung (`if-else`), die den Status des Charakters aktualisiert:
   * Wenn die Lebenspunkte (`hitPoints`) nach dem Schaden größer als 0 sind, bleibt der Status `ALIVE`.
   * Wenn die Lebenspunkte gleich 0 sind, wird der Status auf `STUNNED` gesetzt.
   * Wenn die Lebenspunkte kleiner als 0 sind, wird der Status auf `DEAD` gesetzt.

   (10 Punkte)
3. Implementieren Sie in der `fight`-Methode der [`DungeonsAndDragons`](src/main/java/de/phl/programmingproject/dnd/DungeonsAndDragons.java)-Klasse eine `while`-Schleife, die einen Kampf zwischen einem Charakter und einem Monster simuliert:
   * Solange sowohl der Charakter als auch das Monster den Status `ALIVE` haben, führen Sie abwechselnd Angriffe durch: 
     * Der Charakter greift das Monster an und gibt die Angriffsbeschreibung in der Konsole aus. 
     * Wenn das Monster nach dem Angriff noch `ALIVE` ist, greift es den Charakter an.
   * Nach dem Kampf geben Sie den Endstatus des Charakters und des Monsters in der Konsole aus.

    (15 Punkte)
4. Simulieren Sie einen Kampf in der `main`-Methode der [`DungeonsAndDragons`](src/main/java/de/phl/programmingproject/dnd/DungeonsAndDragons.java)-Klasse:
   * Erstellen Sie einen Charakter mit dem Namen "Leeroy Jenkins", der Klasse `PALADIN` und 100 Lebenspunkten.
   * Erstellen Sie ein Monster mit dem Namen "Goblin", 80 Lebenspunkten und einer Stärke von 10.
   * Rufen Sie die `fight`-Methode auf, um den Kampf zu starten.

   (5 Punkte)

5. Implementieren Sie in der `createMonsters`-Methode der [`DungeonsAndDragons`](src/main/java/de/phl/programmingproject/dnd/DungeonsAndDragons.java)-Klasse eine `for`-Schleife, die genau 20 Monster erstellt:
   * Der Name des Monsters soll aus dem Array `names` ausgewählt werden, in dem der Name basierend auf dem aktuellen Index der Schleife ausgewählt wird.
   * Die Lebenspunkte (`hitPoints`) des Monsters betragen 50 plus den aktuellen Index der Schleife multipliziert mit 5.
   * Die Stärke (`strength`) des Monsters beträgt 5 plus den aktuellen Index der Schleife multipliziert mit 2.
   * Fügen Sie jedes erstellte Monster zu einer Liste hinzu.
   
   (10 Punkte)