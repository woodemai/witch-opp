* заменил `jdk 1.8` на `jdk 21` чтобы использовать некоторые новые функции
* переименовал констатны, чтобы было понятно что это константы (Six -> SIX)
* заменил перемешивание на `Collections.shuffle(cards);`
* заменил `ArrayList<Card>` на `List<Card>`, лучше использовать интерфейс а не реализацию
* заменил `deck.getCards().remove(deck.getCards().size() - 1)` на `deck.getCards().removeLast()`