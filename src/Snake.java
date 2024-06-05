import java.util.Scanner;

public class Snake {
    Field field;

    void setupNewGame() {
        System.out.println("Игра началась!!!");
        this.field = new Field();
    }

    char askWhereToGo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nКуда двинется змейка: направо (d), вверх (w), вниз (s) или влево (a)? ");
        char direction = scanner.next().charAt(0);
        return direction;
    }

    void turn(char direction) {
        if (direction == 'd') {
            this.field.newFieldAfterTurnRight();
        } else if (direction == 'a') {
            this.field.newFieldAfterTurnLeft();
        } else if (direction == 'w') {
            this.field.newFieldAfterTurnUp();
        } else if (direction == 's') {
            this.field.newFieldAfterTurnDown();
        } else {
            System.out.println("Ошибка! Пожалуйста введите: направо (d), вверх (w), вниз (s) или влево (a)");
        }
    }
}
