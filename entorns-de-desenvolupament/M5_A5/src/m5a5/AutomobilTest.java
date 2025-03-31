package m5a5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class AutomobilTest {

    @Test
    void validarMatricula() {
        Automobil automobil = new Automobil("", "", "");
        Assertions.assertFalse(automobil.validarMatricula(""));
        Assertions.assertTrue(automobil.validarMatricula("1234ABC"));
        Assertions.assertFalse(automobil.validarMatricula("123ABC"));
        Assertions.assertFalse(automobil.validarMatricula("12345ABC"));
        Assertions.assertFalse(automobil.validarMatricula("ABCDEF"));
        Assertions.assertFalse(automobil.validarMatricula("123456"));
        Assertions.assertFalse(automobil.validarMatricula("1234abc"));
        Assertions.assertFalse(automobil.validarMatricula("1234!@#"));
    }
}