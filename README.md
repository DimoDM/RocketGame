# Rocket Game

### Описание
Потребителят управлява космически кораб, с който се пробва да се спаси от идващите към него астероидим, като ги стреля със своето оръдие. За всяка изминала секунда и с всеки разрушен астероид играчат получава точки и нивото на трудността се повеиша.

### Време на разработка
Отделеното време по играта общо е около 60 часа.

### Използвани технологии
1. Firebase
2. Dagger2
3. Retrofit
4. Java
5. Android Studio
### Аутентикация
Потребителят може да създаде, впише и запазва своя резултат със своя Google account.

### Възможности за бъдещо развитие
1. Играта ще може да се играе онлайн с приятели, като се сканира QR code или ръчно се въведе ID-то на стаята.
2. Играте ще има магазин, в който играчите ще могат да си копуват подобрения на своите оръжия и кораби.
3. Подобравяне на графиката.
4. Качване в онлайн платфорама и достъпна за изтегляне.

### Важни методи
1. FirebaseRepository.getInstance() - връща сингълтън на FirebaseRepository обекта, с който може да извикваме следните функции:
- createNewPlayer(User newUser) - създава нов потребител в база данни
- updateHighScore(int highScore) - записва новия най-висок резултат на потребителя в базата данни.
- void updateWins(int wins)
- void createRoom(MultiPlayerUser player1) - създава онлайн.
- void setReady() - променя статуса на играч на готов докато е в онлайн стая.
2. QRGenerator.generateCode() - Създава Bitmap QRImage който, може да се сканира от играчите, за да се присъединят към онлайн стая. 
3. RoomCodeGenerator.generateCode() - създава id за стаите.
4. getComponent(...) - взима компонент от обект от играта.
5. addComponent(...) - добавя компонент на обект от играта.
1. getGroup(...) - взима групирарани обекти
7. addGroup(...) - групира обкети
8. draw(...) - рисува текстури
9. checkColide(...) проверява итеракция между обекти
10. inti(), uptade() и draw() override-ват се от компоненти и извършват логиката на различните обекти.
11. Move() - следи за input от играча.
12. getAllUsers() - връща всички потребители от FirebaseDatabase
12. getUser() - връща вписаният играч от FirebaseDatabase

### Източници
> [Stack Overflow](https://stackoverflow.com/) \
[Put View Above Other](https://stackoverflow.com/questions/44351354/android-constraintlayout-put-one-view-on-top-of-another-view) \
 [QR reader](https://www.youtube.com/watch?v=Iuj4C...) \
 [Code in flow](https://www.youtube.com/channel/UC_Fh8kvtkVPkeihBs42jGcA) \
 [Android Developers](https://developer.android.com/) \
 [Create Java Android Game](https://www.androidauthority.com/android-game-java-785331/) \
 [Firebase Docs](https://firebase.google.com/docs?authuser=0)

