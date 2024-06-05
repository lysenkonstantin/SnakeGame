public class Field {

    char[][] field;
    int size = 20;
    int[] rowHead = new int[1000];
    int[] colHead = new int[1000];
    int[] rowApples = new int[]{3, 3, 3, 9, 9, 16, 16, 16};
    int[] colApples = new int[]{3, 9, 15, 3, 15, 3, 9, 15};
    int[] rowWalls = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 14, 15, 16, 17, 18, 14, 15, 16, 17, 18};
    int[] colWalls = new int[]{6, 6, 6, 6, 6, 13, 13, 13, 13, 13, 6, 6, 6, 6, 6, 13, 13, 13, 13, 13};
    int headNumber;
    int tailNumber;
    int applesToWin = 0;

    void initFieldWithSnakeAndApples() {
        this.field = new char[size][size];

        headNumber = 2;
        tailNumber = 0;
        this.rowHead[0] = 9;
        this.colHead[0] = 8;
        this.rowHead[1] = 9;
        this.colHead[1] = 9;
        this.rowHead[2] = 9;
        this.colHead[2] = 10;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == 9 && col >= 8 && col <= 10) {
                    this.field[row][col] = 'S';
                } else {
                    this.field[row][col] = ' ';
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            this.field[this.rowApples[i]][this.colApples[i]] = 'A';
        }
        for (int i = 0; i < 20; i++) {
            this.field[this.rowWalls[i]][this.colWalls[i]] = 'W';
        }
        this.printField();
    }

    void printField() {
        System.out.println("Текущее поле для игры (змейка помечена S, яблоки - A, стены - W)");
        System.out.print("    ");
        for (int i = 1; i <= this.size; i++) {
            if (i < size / 2) {
                System.out.print(i + "   ");
            } else {
                System.out.print(i + "  ");
            }
        }
        System.out.println();
        for (int row = 0; row < this.size; row++) {
            int rowNumber = row + 1;
            if (rowNumber < size / 2) {
                System.out.print(rowNumber + "  ");
            } else {
                System.out.print(rowNumber + " ");
            }
            for (int col = 0; col < size; col++) {
                System.out.print("[" + this.field[row][col] + "] ");
            }
            System.out.println();
        }
    }

    void newFieldAfterTurnRight() {
        if (this.field[this.rowHead[this.headNumber]][this.colHead[this.headNumber] + 1] == ' ') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row][col + 1] = 'S';
                        this.colHead[this.headNumber + 1] = col + 1;
                        this.rowHead[this.headNumber + 1] = row;
                    }
                    if (this.field[row][col] == 'S' && this.rowHead[this.tailNumber] == row && this.colHead[this.tailNumber] == col) {
                        this.field[row][col] = ' ';
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.tailNumber++;
        } else if (this.field[this.rowHead[this.headNumber]][this.colHead[this.headNumber] + 1] == 'A') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row][col + 1] = 'S';
                        this.colHead[this.headNumber + 1] = col + 1;
                        this.rowHead[this.headNumber + 1] = row;
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.applesToWin++;
        } else {
            System.out.println("В этом направлении нельзя ходить! Выберете другое направление!!");
        }
    }

    void newFieldAfterTurnLeft() {
        if (this.field[this.rowHead[this.headNumber]][this.colHead[this.headNumber] - 1] == ' ') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row][col - 1] = 'S';
                        this.colHead[this.headNumber + 1] = col - 1;
                        this.rowHead[this.headNumber + 1] = row;
                    }
                    if (this.field[row][col] == 'S' && this.rowHead[this.tailNumber] == row && this.colHead[this.tailNumber] == col) {
                        this.field[row][col] = ' ';
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.tailNumber++;
        } else if (this.field[this.rowHead[this.headNumber]][this.colHead[this.headNumber] - 1] == 'A') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row][col - 1] = 'S';
                        this.colHead[this.headNumber + 1] = col - 1;
                        this.rowHead[this.headNumber + 1] = row;
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.applesToWin++;
        } else {
            System.out.println("В этом направлении нельзя ходить! Выберете другое направление!!");
        }
    }

    void newFieldAfterTurnDown() {
        if (this.field[this.rowHead[this.headNumber] + 1][this.colHead[this.headNumber]] == ' ') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row + 1][col] = 'S';
                        this.colHead[this.headNumber + 1] = col;
                        this.rowHead[this.headNumber + 1] = row + 1;
                    }
                    if (this.field[row][col] == 'S' && this.rowHead[this.tailNumber] == row && this.colHead[this.tailNumber] == col) {
                        this.field[row][col] = ' ';
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.tailNumber++;
        } else if (this.field[this.rowHead[this.headNumber] + 1][this.colHead[this.headNumber]] == 'A') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row + 1][col] = 'S';
                        this.colHead[this.headNumber + 1] = col;
                        this.rowHead[this.headNumber + 1] = row + 1;
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.applesToWin++;
        } else {
            System.out.println("В этом направлении нельзя ходить! Выберете другое направление!!");

        }
    }

    void newFieldAfterTurnUp() {
        if (this.field[this.rowHead[this.headNumber] - 1][this.colHead[this.headNumber]] == ' ') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row - 1][col] = 'S';
                        this.colHead[this.headNumber + 1] = col;
                        this.rowHead[this.headNumber + 1] = row - 1;
                    }
                    if (this.field[row][col] == 'S' && this.rowHead[this.tailNumber] == row && this.colHead[this.tailNumber] == col) {
                        this.field[row][col] = ' ';
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.tailNumber++;
        } else if (this.field[this.rowHead[this.headNumber] - 1][this.colHead[this.headNumber]] == 'A') {
            for (int row = 0; row < this.size; row++) {
                for (int col = 0; col < this.size; col++) {
                    if (this.field[row][col] == 'S' && this.rowHead[this.headNumber] == row && this.colHead[this.headNumber] == col) {
                        this.field[row - 1][col] = 'S';
                        this.colHead[this.headNumber + 1] = col;
                        this.rowHead[this.headNumber + 1] = row - 1;
                    }
                }
            }
            this.printField();
            this.headNumber++;
            this.applesToWin++;
        } else {
            System.out.println("В этом направлении нельзя ходить! Выберете другое направление!!");
        }
    }

    boolean isGameOver(char direction) {
        boolean dWall1 = direction == 'd' && this.colHead[this.headNumber] == 5 &&
                this.rowHead[this.headNumber] >= 1 && this.rowHead[this.headNumber] <= 5;
        boolean dWall2 = direction == 'd' && this.colHead[this.headNumber] == 5 &&
                this.rowHead[this.headNumber] >= 14 && this.rowHead[this.headNumber] <= 18;
        boolean dWall3 = direction == 'd' && this.colHead[this.headNumber] == 12 &&
                this.rowHead[this.headNumber] >= 1 && this.rowHead[this.headNumber] <= 5;
        boolean dWall4 = direction == 'd' && this.colHead[this.headNumber] == 12 &&
                this.rowHead[this.headNumber] >= 14 && this.rowHead[this.headNumber] <= 18;
        boolean aWall1 = direction == 'a' && this.colHead[this.headNumber] == 7 &&
                this.rowHead[this.headNumber] >= 1 && this.rowHead[this.headNumber] <= 5;
        boolean aWall2 = direction == 'a' && this.colHead[this.headNumber] == 7 &&
                this.rowHead[this.headNumber] >= 14 && this.rowHead[this.headNumber] <= 18;
        boolean aWall3 = direction == 'a' && this.colHead[this.headNumber] == 14 &&
                this.rowHead[this.headNumber] >= 1 && this.rowHead[this.headNumber] <= 5;
        boolean aWall4 = direction == 'a' && this.colHead[this.headNumber] == 14 &&
                this.rowHead[this.headNumber] >= 14 && this.rowHead[this.headNumber] <= 18;
        boolean wWall1 = direction == 'w' && this.colHead[this.headNumber] == 6 && this.rowHead[this.headNumber] == 6;
        boolean wWall2 = direction == 'w' && this.colHead[this.headNumber] == 13 && this.rowHead[this.headNumber] == 6;
        boolean wWall3 = direction == 'w' && this.colHead[this.headNumber] == 6 && this.rowHead[this.headNumber] == 19;
        boolean wWall4 = direction == 'w' && this.colHead[this.headNumber] == 13 && this.rowHead[this.headNumber] == 19;
        boolean sWall1 = direction == 's' && this.colHead[this.headNumber] == 6 && this.rowHead[this.headNumber] == 0;
        boolean sWall2 = direction == 's' && this.colHead[this.headNumber] == 13 && this.rowHead[this.headNumber] == 0;
        boolean sWall3 = direction == 's' && this.colHead[this.headNumber] == 6 && this.rowHead[this.headNumber] == 13;
        boolean sWall4 = direction == 's' && this.colHead[this.headNumber] == 13 && this.rowHead[this.headNumber] == 13;

        if (this.applesToWin == 8) {
            System.out.println("Вы съели все фрукты!");
            return true;
        } else if (direction == 'd' && this.colHead[this.headNumber] == 19) {
            System.out.println("Вы врезались в правый край поля!");
            return true;
        } else if (direction == 'a' && this.colHead[this.headNumber] == 0) {
            System.out.println("Вы врезались в левый край поля!");
            return true;
        } else if (direction == 'w' && this.rowHead[this.headNumber] == 0) {
            System.out.println("Вы уперлись в потолок!");
            return true;
        } else if (direction == 's' && this.rowHead[this.headNumber] == 19) {
            System.out.println("Вы провалились в пол!");
            return true;
        } else if (dWall1 || dWall2 || dWall3 || dWall4) {
            System.out.println("Вы врезались в стену c левой стороны!");
            return true;
        } else if (aWall1 || aWall2 || aWall3 || aWall4) {
            System.out.println("Вы врезались в стену с правой стороны!");
            return true;
        } else if (wWall1 || wWall2 || wWall3 || wWall4) {
            System.out.println("Вы врезались в стену снизу!");
            return true;
        } else if (sWall1 || sWall2 || sWall3 || sWall4){
            System.out.println("Вы врезались в стену сверху!");
            return true;
        } else return false;
    }

}