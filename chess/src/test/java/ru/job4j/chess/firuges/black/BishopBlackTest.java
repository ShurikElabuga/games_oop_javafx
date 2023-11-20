package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static ru.job4j.chess.firuges.Cell.D7;
import static ru.job4j.chess.firuges.Cell.G5;

class BishopBlackTest {

    @Test
    void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell expected = Cell.C1;
        assertThat(bishopBlack.position()).isEqualTo(expected);
    }

    @Test
    void whenCopyRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell expected = Cell.A3;
        assertThat(bishopBlack.copy(Cell.A3).equals(expected));
    }

    @Test
    void whenWayRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, G5};
        assertThat(bishopBlack.way(G5)).isEqualTo(expected);
    }

    @Test
    void whenWayWrong() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(D7)
        );
        String expected = "Could not way by diagonal from C1 to D7";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}