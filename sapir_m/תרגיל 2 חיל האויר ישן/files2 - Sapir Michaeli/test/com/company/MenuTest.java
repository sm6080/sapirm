package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sapir Michaeli on 14.03.2017.
 */
class MenuTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void encryptionTest() {
        if (!new Menu().programMenu("1").equals("Encryption"))
            Assertions.fail("not encryption");
    }

    @Test
    void decryptionTest() {
        if (!new Menu().programMenu("2").equals("Decryption"))
            Assertions.fail("not decryption");
    }

    @Test
    void stringTest() {
        if (new Menu().programMenu("hgurhguh").equals(null))
            Assertions.fail("invalid input");
    }

    @Test
    void wrongNumberTest() {
        if (!new Menu().programMenu("3").equals(null))
            Assertions.fail("invalid input");
    }

    @Test
    void emptyTest() {
        if (new Menu().programMenu("").equals(null))
            Assertions.fail("invalid input");
    }
}