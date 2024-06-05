public class Main {

    public static void main(String[] args) {

        Snake snake = new Snake();
        snake.setupNewGame();
        snake.field.initFieldWithSnakeAndApples();
        while (true) {
            char direction = snake.askWhereToGo();
            if (snake.field.isGameOver(direction)) {
                System.out.println("Игра окончена!");
                break;
            }
            snake.turn(direction);

        }
    }
}
