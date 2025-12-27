package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {

    @Test
    public void maleLionHasMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleLionHasNoMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionThrowsExceptionForInvalidSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        new Lion("Котик", feline);
    }

    @Test
    public void femaleLionGetKittensUsesFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самка", feline);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void maleLionGetKittensReturnsZero() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertEquals(0, lion.getKittens());
    }

    @Test
    public void getFoodUsesFelineEatMeat() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Мясо"), lion.getFood());
    }
}
