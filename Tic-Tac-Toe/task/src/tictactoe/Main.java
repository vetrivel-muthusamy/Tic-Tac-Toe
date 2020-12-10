package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Obtained
    private char[] data;
    private GameState state = GameState.START;

    public Main() {
        manage(null);
    }

    public void manage(String input) {
        switch (state) {
            case START:
                turnOnState(GameState.ENTER_CELLS, "Enter cells: ");
                break;
            case ENTER_CELLS:
                enterCells(input);
                turnOnEnterCrd();
                break;
            case ENTER_CRD:
                manageEnteringCoordinates(input);
                break;
        }
    }

    private void turnOnEnterCrd() {
        turnOnState(GameState.ENTER_CRD, "Enter the coordinates: ");
    }

    private void turnOnState(GameState state, String msg) {
        this.state = state;
        if (msg != null) {
            System.out.print(msg);
        }
    }

    private void enterCells(String input) {
        data = input.toCharArray();
        System.out.println(render(false));
    }

    private void manageEnteringCoordinates(String input) {
        int[] crd = parseAndCheckCrd(input);
        if (crd != null) {
            setFieldByCrd('X', crd);
            turnOnState(GameState.DONE, render(false) + '\n');
        } else {
            turnOnEnterCrd();
        }
    }

    private int[] parseAndCheckCrd(String input) {
        if (!input.matches("\\d +\\d")) {
            System.out.println("You should enter numbers!");
            return null;
        }
        // Here the input is 2 numbers in range [0, 9]

        if (!input.matches("[1-3] +[1-3]")) {
            System.out.println("Coordinates should be from 1 to 3!");
            return null;
        }
        // Here, the input is 2 numbers in range [1, 3]

        int[] crd = Arrays.stream(input.split(" +")).mapToInt(Integer::parseInt).toArray();
        if (isFieldByCrdOccupied(crd)) {
            return null;
        }
        return crd;
    }

    private boolean isFieldByCrdOccupied(int[] crd) {
        char field = getFieldByCrd(crd);
        if (field == 'X' || field == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }
        return false;
    }

    private char getFieldByCrd(int[] crd) {
        return data[flattenCrd(crd)];
    }

    private void setFieldByCrd(char field, int[] crd) {
        data[flattenCrd(crd)] = field;
    }

    private int flattenCrd(int[] crd) {
        return 8 - 3 * crd[1] + crd[0];
    }

    public String render(boolean includeGameState) {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (int row = 0; row < 3; row++) {
            bodyLine(sb, row * 3);
        }
        sb.append("---------");
        if (includeGameState) {
            sb.append(chooseGameState()).append('\n');
        }
        return sb.toString();
    }

    private void bodyLine(StringBuilder sb, int shift) {
        sb.append("| ");
        for (int x = 0; x < 3; x++) {
            char field = data[shift + x];
            sb.append(field == '_' ? ' ' : field).append(' ');
        }
        sb.append("|\n");
    }

    private String chooseGameState() {
        return "";
    }

    enum GameState {
        START,
        ENTER_CELLS,
        ENTER_CRD,

        DONE
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main ticTac = new Main();
        while (ticTac.state != GameState.DONE) {
            ticTac.manage(scanner.nextLine());
        }
    }
}