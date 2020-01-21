package code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PasscodeTest {

    @Test
    public void testValid() {
        assertThat(new Passcode("112").isValidForDay1()).isTrue();
    }

    @Test
    public void testValid2() {
        assertThat(new Passcode("355").isValidForDay1()).isTrue();
    }

    @Test
    public void testNoDuplicates() {
        assertThat(new Passcode("123").isValidForDay1()).isFalse();
    }

    @Test
    public void testDescending() {
        assertThat(new Passcode("776").isValidForDay1()).isFalse();
    }

    @Test
    public void testJustWrong() {
        assertThat(new Passcode("987").isValidForDay1()).isFalse();
    }

}